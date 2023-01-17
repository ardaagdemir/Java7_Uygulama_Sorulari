package oop_16_Ocak_Tekrar.example5;

public class Kisi extends User{

    private String isim;
    private String telNo;

    public Kisi(String soyad, String isim, String telNo) {
        super(soyad);
        this.isim = isim;
        this.telNo = telNo;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    @Override
    public String toString() {
        return "Kisi{" +
                "isim='" + isim + '\'' +
                ", telNo='" + telNo + '\'' +
                ", " + super.toString() +
                "} ";
    }
}
