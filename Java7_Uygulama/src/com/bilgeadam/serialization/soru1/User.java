package com.bilgeadam.serialization.soru1;

import java.io.Serializable;

public class User implements Serializable {

    private String isim;
    private String soyisim;

    public User(String isim, String soyisim) {
        this.isim = isim;
        this.soyisim = soyisim;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    @Override
    public String toString() {
        return "User{" +
                "isim='" + isim + '\'' +
                ", soyisim='" + soyisim + '\'' +
                '}';
    }
}
