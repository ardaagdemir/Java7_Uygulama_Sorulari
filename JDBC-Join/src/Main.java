import entity.Category;
import entity.DB;
import entity.Product;
import service.ProductService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ProductService productService = new ProductService();
        productService.getAll();

        Product product1 = new Product(null, new Category(3, null), "Termos", 400, "Starbucks");
        Product product2 = new Product( null, new Category(6, null), "Kazak", 1000, "Levi's");
        //productService.save(product1);
        //productService.update(product1);

        //List<Product> lsProducts = Arrays.asList(product1,product2);
        //productService.saveAll(lsProducts);
        //productService.delete(25);
        //productService.getById(29);
    }
}
