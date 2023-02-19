package com.bilgeadam;

import com.bilgeadam.entity.Category;
import com.bilgeadam.entity.Product;
import com.bilgeadam.repository.CategoryDao;
import com.bilgeadam.util.HibernateUtil;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();

        CategoryDao categoryDao = new CategoryDao();

        Category category = new Category("moda", Arrays.asList(new Product("deneme", 123, 4)));
        categoryDao.create(category);
    }
}
