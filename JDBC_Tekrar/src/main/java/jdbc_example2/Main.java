package jdbc_example2;


import jdbc_example2.entity.Category;
import jdbc_example2.entity.Customer;
import jdbc_example2.entity.Product;
import jdbc_example2.service.CustomerService;
import jdbc_example2.service.ProductService;

public class Main {

    static ProductService productService = new ProductService();
    static CustomerService customerService = new CustomerService();

    public static void main(String[] args) {

        Product product1 = new Product(new Category(1), "Telefon", 3000, 2, "Samsung s22");
        //productService.save(product1);
        //productService.read();
        productService.countByCategories();

        Customer customer1 = new Customer("Arda", "1231241", new Product(5));
        //customerService.save(customer1);
        //customerService.read();
        //customerService.likeByCustomerName("arda");
        //customerService.whereByPrice(2500, "a");



    }
}
