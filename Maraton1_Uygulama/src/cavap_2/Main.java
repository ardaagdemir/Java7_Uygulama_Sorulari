package cavap_2;
import java.security.PublicKey;

public class Main {

	public static void main(String[] args) {

		int sayilar[] = { 3, 5, 7, 2, 4, 6, 8, 5, 9,};
		ilkTekrarEdenSAyi(sayilar);

	}

	public static void ilkTekrarEdenSAyi(int[] arr) {
		int sayac = 1;
		int sayi = 0;
		
		for (int i = 0; i < arr.length; i++) {
			sayi = arr[i];
			for(int j = i+1; j<arr.length; j++) {
				if(sayi == arr[j]){
					i = arr.length;
					sayac++;
				}
			}
		}
		
		if (sayac == 1) {
			System.out.println("Sayı yok");
		}
		else {
			System.out.println(sayi + " sayısı" + sayac + " defa tekrar ediyor");
		}
	}
}
