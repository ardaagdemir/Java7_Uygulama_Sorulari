package com.bilgeadam.join.school.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Okul {
    //sequence
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String okulAdi;

    //fetchType LAZY --> Default olarak LAZY' dir. Yani ilişkiyi barındıran entity'nin(Okul) yüklenmesi, -->
    //ilişkinin diğer tarafındaki entity'lerin(Sinif) yüklenmesini gerektirmez.

    //Sayfada yer alan bir öğenin ihityaç duyulmadığı taktirde çağrılmaması prensibi ile çalışır.
    // Yani bir nesne örneğinin gerçekten ihtiyaç duyulacağı ana kadar alınmaması ve bekletilmesi amacıyla kullanılır.

    //EAGER --> Lazy' nin tam tersi çalışır. Kullanılacak nesneleri, önceden yaratır ve sorgu çalıştırıldığında verilerin aynı anda yüklenmesini sağlar.
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "okul")
    //mappedBy --> M:1(M2O) - 1:M ilişkilerde genellikle bu ilişkiyi yöneten taraf 1:M tarafı olduğu için burada 1:M' ye mapped olarak nesnesi verilir.
    //mappedBy --> M:1 dışında diğer bütün tiplerde kullanılır.Yönetici sınıfta mutlaka tanımlanmalıdır yoksa program hata verir.
    //mappedBy kullanılmazsa ilişki her iki taraftan da yönetilebilir.
    private List<Sinif> siniflar;

    public Okul() {
    }

    public Okul(String okulAdi) {
        this.okulAdi = okulAdi;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOkulAdi() {
        return okulAdi;
    }

    public void setOkulAdi(String okulAdi) {
        this.okulAdi = okulAdi;
    }

    public List<Sinif> getSiniflar() {
        return siniflar;
    }

    public void setSiniflar(List<Sinif> siniflar) {
        this.siniflar = siniflar;
    }

    @Override
    public String toString() {
        return "Okul{" +
                "id=" + id +
                ", okulAdi='" + okulAdi + '\'' +
                ", siniflar=" + siniflar +
                '}';
    }
}
