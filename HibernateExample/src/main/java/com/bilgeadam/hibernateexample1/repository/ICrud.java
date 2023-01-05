package com.bilgeadam.hibernateexample1.repository;

import java.util.List;

public interface ICrud<T> {
    void save(T t);
    void update(T t);
    void deleteById(int id);
    void delete(T t);
    List<T> getAll();
    T geyById(int id);
}
