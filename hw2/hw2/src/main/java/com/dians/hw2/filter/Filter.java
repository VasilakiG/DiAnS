package com.dians.hw2.filter;

public interface Filter<T> {
    public T execute(T input);
}
