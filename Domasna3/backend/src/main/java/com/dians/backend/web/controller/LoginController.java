package com.dians.backend.web.controller;

import com.dians.backend.model.AppUser;
import com.dians.backend.service.AdminUserService;
import com.dians.backend.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;
    private final AdminUserService adminUserService;

    public LoginController(UserService userService, AdminUserService adminUserService) {
        this.userService = userService;
        this.adminUserService = adminUserService;
    }

    @GetMapping
    public String getLoginPage(){
        return "login";
    }

    @PostMapping()
    public String login(HttpServletRequest req, Model model){
        AppUser user = null;

        user = userService.login(req.getParameter("username"), req.getParameter("password"));

        if(user!=null){
            req.getSession().setAttribute("user", user);
            return "redirect:/home";
        }
        else{
            user = adminUserService.login(req.getParameter("username"),req.getParameter("password"));
            req.getSession().setAttribute("user",user);

            return "redirect:/home/admin";
        }

    }


}
