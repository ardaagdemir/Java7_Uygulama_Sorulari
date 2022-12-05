package cevap_3;

import java.util.ArrayList;
import java.util.List;

public class HayvanatBahcesi {

	List<Hayvan> hayvanlar = new ArrayList<>();

	public void memeliHayvanEkle(MemeliHayvan m) {
		hayvanlar.add(m);
	}

	public void surungenEkle(Surungen s) {
		hayvanlar.add(s);
	}

	public void hayvanSesCikarsin(Hayvan h) {
		System.out.println(h.ad + " " + h.sesCikar());
	}

	public void hayvaninCinsiniBul(String hayvanAdi) {
		int sayac = 0;
		for (Hayvan hayvan : hayvanlar) {
			if (hayvan.ad.equals(hayvanAdi)) {
				sayac++;
				System.out.println(hayvanAdi + " bir " + hayvan.getClass().getSuperclass().getSimpleName());
			}
		}
		if (sayac == 0) {
			System.out.println("Böyle bir hayvan yok");
		}
	}
	
	// statik çözüm
	/*int count = 0;
    for(Hayvan hayvan : hayvanatBahcesiList) {       
        if(hayvan.ad.equals(hayvanAdi)) {
            count++;
            if(hayvan instanceof MemeliHayvan)
            {
                System.out.println(hayvan.ad + " bir Memeli Hayvandır.");           
            } else if(hayvan instanceof Surungen){
                System.out.println(hayvan.ad + " bir Surungen Hayvandır." ); 
            }
        }
    }
    if(count==0) {
        System.out.println( hayvanAdi + " isimli bir hayvan hayvanat bahcesinde yok.");
    }*/

	public void hayvaninBilgileriniYazdir(String hayvanAdi) {
		int sayac = 0;
		for (Hayvan hayvan : hayvanlar) {
			if (hayvan.ad == hayvanAdi) {
				sayac++;
				System.out.println(hayvan);
				/*
				 * if (hayvan.getClass().getSimpleName().equals("Aslan") ||
				 * hayvan.getClass().getSimpleName().equals("Yılan")) { hayvan.tehlikeliMi =
				 * true; }
				 */
			}
		}
		if (sayac == 0) {
			System.out.println("Böyle bir hayvan yok.");
		}
	}

	public void hayvaniHareketEttir(String hayvanAdi) {
		int sayac = 0;
		for (Hayvan hayvan : hayvanlar) {
			if (hayvan.ad == hayvanAdi) {
				sayac++;
				// Sorudaki senaryo için aşağıdaki if, elseif koşulları yeterlidir.
				/*
				 * if (hayvan instanceof MemeliHayvan) { System.out.println(hayvanAdi +
				 * " isimli " + hayvan.getClass().getSimpleName() + " yürüyor."); } else if
				 * (hayvan instanceof Surungen) { System.out.println(hayvanAdi + " isimli " +
				 * hayvan.getClass().getSimpleName() + " sürünüyor."); }
				 */

				// Statik yapıda kontrol
				if (hayvan.getClass().getSimpleName().equals("Aslan")) {
					System.out.println(hayvanAdi + " isimli " + hayvan.getClass().getSimpleName() + " yürüyor.");
				} else if (hayvan.getClass().getSimpleName().equals("Yılan")) {
					System.out.println(hayvanAdi + " isimli " + hayvan.getClass().getSimpleName() + " sürünüyor.");
				} else if (hayvan.getClass().getSimpleName().equals("Maymun")) {
					System.out.println(hayvanAdi + " isimli " + hayvan.getClass().getSimpleName() + " koşuyor.");
				}
			}
		}
		if (sayac == 0) {
			System.out.println("Böyle bir hayvan yok");
		}
	}
}
