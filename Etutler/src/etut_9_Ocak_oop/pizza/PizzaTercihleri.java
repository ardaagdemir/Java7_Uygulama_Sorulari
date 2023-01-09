package etut_9_Ocak_oop.pizza;

public class PizzaTercihleri {

    private int sosFiyati = 4;
    private int peynirFiyati = 10;
    private int kuriyeFiyati = 20;

    public void sosEkle(Pizza pizza){
        System.out.println("Sos Eklendi: " + sosFiyati + "TL");
        pizza.setFiyat(pizza.getFiyat() + sosFiyati);
        pizza.setSosEklendiMi(true);
    }

    public void sosCikar(Pizza pizza){
        if(pizza.isSosEklendiMi()){
            System.out.println("Sos cikarildi: " + -sosFiyati);
            pizza.setFiyat(pizza.getFiyat() - sosFiyati);
        }else{
            System.out.println("Sos eklenmedi.");
        }
    }

    public void peynirEkle(Pizza pizza){

    }
    public void peynirCikar(Pizza pizza){

    }

    public void eveSiparisVer(Pizza pizza){
        pizza.setFiyat(pizza.getFiyat() + kuriyeFiyati);
    }

    public void siparisiSil(Pizza pizza){

    }

    public void eveSiparişiIptalEt(Pizza pizza){

    }

    @Override
    public String toString() {
        return "PizzaTercihleri{" +
                "sosFiyati=" + sosFiyati +
                ", peynirFiyati=" + peynirFiyati +
                ", kuriyeFiyati=" + kuriyeFiyati +
                '}';
    }
}
