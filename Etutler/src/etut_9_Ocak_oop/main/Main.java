package etut_9_Ocak_oop.main;

import etut_9_Ocak_oop.pizza.Pizza;
import etut_9_Ocak_oop.pizza.PizzaTercihleri;

public class Main {

    public static void main(String[] args) {

        Pizza pizza1 = new Pizza(true);

        Pizza pizza2 = new Pizza(false);
        Pizza pizza3 = new Pizza(true);
        Pizza pizza4 = new Pizza(false);

        Pizza[] pizzalar = {pizza1, pizza2, pizza3, pizza4};

        PizzaTercihleri pizzaTercihleri = new PizzaTercihleri();
        pizzaTercihleri.sosEkle(pizza1);
        pizzaTercihleri.sosEkle(pizza1);

        pizzaTercihleri.sosEkle(pizza2);
        pizzaTercihleri.sosEkle(pizza2);

        pizzaTercihleri.sosEkle(pizza3);
        pizzaTercihleri.sosEkle(pizza3);
        pizzaTercihleri.sosEkle(pizza3);
        //pizzaTercihleri.sosCikar(pizza1);
        pizzaTercihleri.eveSiparisVer(pizza1);
        pizzaTercihleri.eveSiparisVer(pizza2);
        pizzaTercihleri.eveSiparisVer(pizza3);

        for (int i=0; i< pizzalar.length; i++){
            if (pizzalar[i].getFiyat() < 300){
                System.out.println("Fiyat --> " + pizzalar[i].getFiyat());
            }
        }
    }
}
