package model;

import service.Filter;

import java.util.ArrayList;
import java.util.List;

public class Pipe <T>{
    private List<Filter<T>> filters = new ArrayList<Filter<T>>();

    public Pipe(){};

    public void addFilter(Filter<T> filter){
        filters.add(filter);
    }

    public T runFilters(T input){
        for(Filter<T> filter: filters){
            input = filter.execute(input);
        }
        return input;
    }
}
