package com.bilgeadam.gettersetter;

public class Calisan {

    private static final int ID_HANE = 6;
    private static int VARSAYILAN_ID = 100000;

    private int calisanID;
    public String isim = "unknown";
    public String soyisim = "unknown";

    public Calisan(int calisanID, String isim, String soyisim) {
        this.setCalisanID(calisanID);
        this.isim = isim;
        this.soyisim = soyisim;
    }

    public int getCalisanID() {
        return calisanID;
    }

    public void setCalisanID(int calisanID) {
        if (calisanID < 0){
            System.out.println("CalisanID 0' dan küçük olamaz.");
            if(this.calisanID == 0){
                this.calisanID = VARSAYILAN_ID++;
            }
        }
        else {
            if (String.valueOf(calisanID).length() != ID_HANE){
                System.out.println("Id uzunluğu " + ID_HANE + " karakter olmak zorundadır.");
                if(this.calisanID == 0){
                    this.calisanID = VARSAYILAN_ID++;
                }
            }
            else {
                this.calisanID = calisanID;
            }
        }
    }

    @Override
    public String toString() {
        return "Calisan{" +
                "calisanID=" + calisanID +
                ", isim='" + isim + '\'' +
                ", soyisim='" + soyisim + '\'' +
                '}';
    }
}
