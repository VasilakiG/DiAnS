package service.impl;

import service.Filter;

public class ToLowerFilter<T> implements Filter<String> {
    @Override
    public String execute(String input) {
        String res = input.toString().toLowerCase();
        return res;
    }
}
