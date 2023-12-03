package com.dians.backend.filter;

public interface Filter<T> {
    public T execute(T input);
}
