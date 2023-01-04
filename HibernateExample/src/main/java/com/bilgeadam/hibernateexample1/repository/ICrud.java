package com.bilgeadam.hibernateexample1.repository;

public interface ICrud<T> {

    void save(T t);
}
