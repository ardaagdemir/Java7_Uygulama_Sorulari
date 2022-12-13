package com.bilgeadam.serialization.soru1;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        //Bir tane User sınıfı oluşturalım(isim, soyisim) -->Serializable implement olacak
        //Main metodunda dosyaYaz ve dosyaOku metotları olsun
        //Userdan nesne üretip serileştirirerek dosyaya yazalım daha sonra okuyalım
        //ObjectOutputStream, ObjectInputStream

        User user1 = new User("Ayşe", "Bilir");
        //dosyaYaz(user1);
        dosyaOku(user1);

    }

    public static void dosyaYaz(User user){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("person.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(user);
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void dosyaOku(User user){
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("person.txt"));
            user = (User) objectInputStream.readObject();
            System.out.println(user);
            objectInputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
