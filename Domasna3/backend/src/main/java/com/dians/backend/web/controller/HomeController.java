package com.dians.backend.web.controller;

import com.dians.backend.model.Landmark;
import com.dians.backend.repository.LandmarkRepository;
import com.dians.backend.service.LandmarkService;
import com.dians.backend.service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping({"/home", "/"})
public class HomeController {

    private final LandmarkService landmarkService;
    private final ReviewService reviewService;
    private final LandmarkRepository landmarkRepository;

    public HomeController(LandmarkService landmarkService, ReviewService reviewService, LandmarkRepository landmarkRepository) {
        this.landmarkService = landmarkService;
        this.reviewService = reviewService;
        this.landmarkRepository = landmarkRepository;
    }

    @GetMapping
    public String getHomePage(Model model){
        model.addAttribute("landmarks",landmarkService.findAll());
        return "home";
    }

    @GetMapping("/search")
    public String getFilteredLandmarks(@RequestParam String searchType, Model model){
        if(!searchType.isEmpty()){
            model.addAttribute("landmarks",landmarkService.searchByHistoric(searchType));
        }else{
            model.addAttribute("landmarks",landmarkService.findAll());
        }
        return "home";
    }

    @GetMapping("/add-review-form/{id}")
    public String getAddReviewForm(@PathVariable Long id, Model model){
        model.addAttribute("landmark", landmarkService.findById(id).get());
        return "add-review";
    }

    @PostMapping("/addReview")
    public String addReviewToLandmark(@RequestParam Long id,
                                      @RequestParam Integer score,
                                      @RequestParam String desc){
        reviewService.addReviewToLandmark(id, score, desc);
        return "redirect:/home";
    }

    @GetMapping("/reviews/{id}")
    public String getReviewsForLandmark(@PathVariable Long id, Model model){
        Landmark landmark = landmarkService.findById(id).orElseThrow();
        model.addAttribute("reviews",landmark.getReviewList());

        return "review-list";
    }

    @GetMapping("/admin")
    public String getAdminHomePage(Model model){
        model.addAttribute("landmarks",landmarkService.findAll());
        return "admin-home";
    }

    @PostMapping("/admin/delete/{id}")
    public String deleteLandmark(@PathVariable Long id){
        landmarkService.deleteById(id);

        return "redirect:/home/admin";
    }

    @GetMapping("/admin/edit-form/{id}")
    public String getEditPage(@PathVariable Long id, Model model){
        if(landmarkService.findById(id).isPresent()){
            Landmark landmark = landmarkService.findById(id).get();
            model.addAttribute("landmark", landmark);

            return "edit-landmark";
        }

        return "redirect:/home/admin?error=LandmarkNotFound";
    }

    @GetMapping("/admin/add-form")
    public String getAddPage(){
        return "add-landmark";
    }

    @PostMapping("/admin/add")
    public String addLandmark(@RequestParam String historic,
                              @RequestParam String tourism,
                              @RequestParam String way){
        landmarkService.save(historic,tourism,way);

        return "redirect:/home/admin";
    }

    @PostMapping("/admin/edit/{id}")
    public String editLandmark(@PathVariable("id") Long id,
                               @RequestParam String historic,
                               @RequestParam String tourism,
                               @RequestParam String way){
        landmarkService.edit(id,historic,tourism,way);

        return "redirect:/home/admin";
    }
}
