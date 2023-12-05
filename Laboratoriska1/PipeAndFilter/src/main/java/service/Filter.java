package service;

import java.io.FileFilter;

public interface Filter<T>{
    public T execute(T input);
}
