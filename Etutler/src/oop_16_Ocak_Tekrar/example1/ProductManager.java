package oop_16_Ocak_Tekrar.example1;

public class ProductManager {

    public void bilgileriGoster(Product product){
        System.out.println(
                "Name--> " + product.getName() +
                " Id--> " + product.getProductId() +
                " Price--> " + product.getUnitPrice() +
                " Stock--> " + product.getUnitInStock()
        );
    }

    public void veriTabaninaKaydet(Product product){
        System.out.println(product.getName() + " veritabanına kaydedildi.");
    }

    public void sepeteEkle(Product product){
        System.out.println(product.getName() + " sepete eklendi.");
    }

    public Product urunuGuncelle(Product product, String name){
        product.setName(name);
        return product;
    }

}
