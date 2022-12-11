package com.bilgeadam.file_example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileExample extends Object{
	public static void dosyaYarat(File file) throws IOException {
		if(file.exists()) {
			System.out.println("Dosya zaten var.");
		}
		else {
			if(!file.createNewFile()) {
				System.out.println("Dosya oluştururken hata oluştu");
			}
			else {
				System.out.println("Dosya oluşturdu.");
			}
		}
	}
	
	public static void dosyayaYaz(File file) throws IOException, FileNotFoundException {
		
		if(file.exists()) {
			FileWriter fileWriter = new FileWriter(file, true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write("Soyisim" + "\n");
			bufferedWriter.close();
			System.out.println("Dosyaya yazma işlemi yapıldı.");
		}
		else {
			System.out.println("Dosya bulunamadı.");
		}		
	}
	
	public static void dosyaOku(File file) throws IOException {
		
		if(file.exists()) {
			String line; 
			
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			while((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
		}else {
			System.out.println("Dosya bulunamadı");
		}
		
	}
}
