package service.impl;

import service.Filter;

import java.util.Arrays;

public class NoNamesFilter<T> implements Filter<String> {
    @Override
    public String execute(String input) {
        String[] fields = input.toString().split(",");
        String[] noNames = Arrays.copyOfRange(fields,2,fields.length);

        String res ="";
        for(String field: noNames){
            res += field + ",";
        }

        return res.substring(0,res.length()-1);
    }
}