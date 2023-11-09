package service.impl;

import service.Filter;

public class ToLowerFilter implements Filter {
    @Override
    public String execute(Object input) {
        String res = input.toString().toLowerCase();
        return res;
    }
}
