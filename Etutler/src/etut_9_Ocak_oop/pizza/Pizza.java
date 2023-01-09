package etut_9_Ocak_oop.pizza;

import etut_9_Ocak_oop.main.Main;

//İki tip class vardır.
//Biri hem özellik hem metot içeren classlar(fonksiyonel class)
//Bir de entity classlar(özellik içeren classlar) vardır
 public class Pizza{
    private int fiyat;
    private boolean vegi;
    private boolean sosEklendiMi;
    private int vegiFiyat = 300;
    private int normalFiyat = 200;

    public Pizza(boolean vegi){
        System.out.println("constructor calisti");
        this.vegi = vegi;

        //Emre's if
        if (this.vegi){
            this.fiyat = vegiFiyat;
        }else{
            this.fiyat = normalFiyat;
        }
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    public boolean isVegi() {
        return vegi;
    }

    public void setVegi(boolean vegi) {
        this.vegi = vegi;
    }

    public boolean isSosEklendiMi() {
        return sosEklendiMi;
    }

    public void setSosEklendiMi(boolean sosEklendiMi) {
        this.sosEklendiMi = sosEklendiMi;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "fiyat=" + fiyat +
                ", vegi=" + vegi +
                ", sosEklendiMi=" + sosEklendiMi +
                '}';
    }
}
