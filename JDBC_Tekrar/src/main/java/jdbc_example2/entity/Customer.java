package jdbc_example2.entity;

import java.util.List;

public class Customer {

    private Integer id;
    private String name;
    private String identityNumber;
    //product
    private Product product;

    public Customer(String name, String identityNumber, Product product) {
        this.name = name;
        this.identityNumber = identityNumber;
        this.product = product;
    }

    public Customer(Integer id, String name, String identityNumber, Product product) {
        this.id = id;
        this.name = name;
        this.identityNumber = identityNumber;
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", identityNumber='" + identityNumber + '\'' +
                ", product=" + product +
                '}';
    }
}
