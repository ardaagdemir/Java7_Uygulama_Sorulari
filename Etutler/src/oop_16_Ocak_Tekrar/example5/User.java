package oop_16_Ocak_Tekrar.example5;

public class User {

    private String soyad;

    public User(String soyad) {
        this.soyad = soyad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    @Override
    public String toString() {
        return "soyad=" + soyad;
    }
}
