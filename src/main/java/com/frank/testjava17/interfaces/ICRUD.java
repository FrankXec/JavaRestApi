package com.frank.testjava17.interfaces;

import java.util.List;

public interface ICRUD <T>{
    List<T> getAll();
    T getOneById(String id);
    boolean create(T entity);
    boolean update(T entity);
    boolean delete(String id);
}
