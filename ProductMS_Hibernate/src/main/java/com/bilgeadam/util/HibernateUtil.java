package com.bilgeadam.util;

import com.bilgeadam.entity.Category;
import com.bilgeadam.entity.Customer;
import com.bilgeadam.entity.Product;
import com.bilgeadam.entity.ProductDetail;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null){
            try{
                Configuration configuration = new Configuration();
                configuration.addAnnotatedClass(Category.class);
                configuration.addAnnotatedClass(Product.class);
                configuration.addAnnotatedClass(Customer.class);
                configuration.addAnnotatedClass(ProductDetail.class);
                sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
