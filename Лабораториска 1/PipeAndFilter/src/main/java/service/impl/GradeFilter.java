package service.impl;

import service.Filter;

import java.util.Arrays;

public class GradeFilter<T> implements Filter<String> {
    @Override
    public String execute(String input) {
        String[] fields = input.toString().split(",");
        String grade = fields[fields.length-1].toLowerCase();
        if (grade.length()<3) {
            int newGrade = Integer.parseInt(grade) - 5;
            fields[fields.length-1] = String.valueOf(newGrade);
        }

        //Reconstruct the modified input
        StringBuilder modifiedInput = new StringBuilder();
        for(String field: fields){
            modifiedInput.append(field).append(",");
        }
        return modifiedInput.substring(0,modifiedInput.length()-1);// Remove the trailing comma
    }
}
