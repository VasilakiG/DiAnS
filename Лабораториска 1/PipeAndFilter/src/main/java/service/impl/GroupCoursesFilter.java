package service.impl;

import service.Filter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GroupCoursesFilter<T> implements Filter<String> {

    private Map<String, String> courseGroups;

    public GroupCoursesFilter() {
        courseGroups = new HashMap<>();
        initializeCourseGroups(); // Initialize the course-group mapping
    }

    private void initializeCourseGroups(){
        courseGroups.put("calculus", "math");
        courseGroups.put("discrete mathematics", "math");
        courseGroups.put("probability and statistics", "math");
        courseGroups.put("software architecture and design", "software engineering");
        courseGroups.put("software requirements analysis", "software engineering");
        courseGroups.put("structural programming", "programming");
        courseGroups.put("object oriented programming", "programming");
        courseGroups.put("algorithms and data structures", "programming");
    }
    @Override
    public String execute(String input) {
        String res = "";
        String [] fields = input.toString().split(",");
        for (int i = 1; i < fields.length; i++) {
            String currentField = fields[i];
            if (courseGroups.containsKey(currentField)) {
                fields[i] = courseGroups.get(currentField);
            }
        }

        StringBuilder modifiedInput = new StringBuilder();
        for (String field : fields) {
            modifiedInput.append(field).append(",");
        }
        return modifiedInput.substring(0, modifiedInput.length()-1);// Remove the trailing comma
    }
}
