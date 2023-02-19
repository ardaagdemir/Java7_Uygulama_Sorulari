package com.bilgeadam.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> product;

    public Category(String name, List<Product> product) {
        this.name = name;
        this.product = product;
    }

    //id      name
    //1    elektronik


    //category_product table
    //category_id         product_id
    //    1                   1
    //    1                   2
    //    1                   3



    //product table
    //productid    name   price  categoryID
    //  1          asdasd   123     1
    //  2           as      12      1
    //  3            as   123       1
}
