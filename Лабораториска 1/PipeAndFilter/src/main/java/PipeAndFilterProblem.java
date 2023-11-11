import model.Pipe;
import service.impl.GradeFilter;
import service.impl.GroupCoursesFilter;
import service.impl.NoNamesFilter;
import service.impl.ToLowerFilter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PipeAndFilterProblem {

    public static void main(String[] args) throws FileNotFoundException {
        ClassLoader loader = PipeAndFilterProblem.class.getClassLoader();
        Scanner scanner = new Scanner(new File(loader.getResource("student_grades.csv").getFile()));

        Pipe<String> pipe1 = new Pipe<>();
        Pipe<String> pipe2 = new Pipe<>();

        ToLowerFilter toLowerFilter = new ToLowerFilter();
        NoNamesFilter noNamesFilter = new NoNamesFilter();
        GroupCoursesFilter groupCoursesFilter = new GroupCoursesFilter();
        GradeFilter gradeFilter = new GradeFilter();
        pipe1.addFilter(toLowerFilter);
        pipe1.addFilter(noNamesFilter);
        pipe1.addFilter(groupCoursesFilter);

        pipe2.addFilter(gradeFilter);
        pipe2.addFilter(noNamesFilter);

        Map<String, Integer> gradesByCourseGroup = new HashMap<String, Integer>();
        Map<String, Double> numberPassing = new HashMap<String, Double>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            //start pipe1
            String line1 = pipe1.runFilters(line);
            //run pipe1

            String[] fields = line1.split(",");

            if (fields[2].length() < 3 && Integer.parseInt(fields[2]) > 5){
                if (gradesByCourseGroup.containsKey(fields[1])){
                    gradesByCourseGroup.put(fields[1], gradesByCourseGroup.get(fields[1]) + Integer.valueOf(fields[2]));
                }
                else {
                    gradesByCourseGroup.put(fields[1], Integer.valueOf(fields[2]));
                }

                if (numberPassing.containsKey(fields[1])){
                    numberPassing.put(fields[1], numberPassing.get(fields[1]) + 1);
                }
                else {
                    numberPassing.put(fields[1], 1.0);
                }

                //System.out.println(line1);
            }

            System.out.println(line1);

            //start pipe2
            String line2 = pipe2.runFilters(line);
            //run pipe2
            System.out.println(line2);



        }

        for (Map.Entry<String, Integer> grade: gradesByCourseGroup.entrySet()){
            System.out.println(grade.getKey() + " " + grade.getValue() / numberPassing.get(grade.getKey()));
        }

    }
}
