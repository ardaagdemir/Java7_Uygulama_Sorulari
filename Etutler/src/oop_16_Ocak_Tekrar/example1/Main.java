package oop_16_Ocak_Tekrar.example1;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        Product product1 = new Product();
        product1.setName("Asus Laptop");
        product1.setProductId(1);
        product1.setUnitInStock(100);
        product1.setUnitPrice(15000);

        Product product2 = new Product();
        product2.setName("Lenova Laptop");
        product2.setProductId(2);
        product2.setUnitInStock(75);
        product2.setUnitPrice(18000);

        Product[] products = new Product[2];
        products[0] = product1;
        products[1] = product2;

        for(int i = 0; i<products.length; i++){
            productManager.bilgileriGoster(products[i]);
        }

        //products arrayini dönerek içerisindeki her bir elemanı Product tipinde bir item değişkenine eşitliyor.
        for (Product item : products){
            System.out.println(item);
        }

        productManager.veriTabaninaKaydet(product1);
        productManager.sepeteEkle(product1);

        Product newName = productManager.urunuGuncelle(product1, "HP");
        System.out.println("Değişen isim --> " + newName.getName());
    }


}
