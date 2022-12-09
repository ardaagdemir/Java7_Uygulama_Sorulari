package fileexample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Main{
	public static void main(String[] args) {
		
		String dosyaYolu = "deneme.txt";
		File file = new File(dosyaYolu);
		
		//Dosya oluştur
//		try {
//			FileExample.dosyaYarat(file);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
			
		//Dosyaya yaz
		try {
			FileExample.dosyayaYaz(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			FileExample.dosyaOku(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
