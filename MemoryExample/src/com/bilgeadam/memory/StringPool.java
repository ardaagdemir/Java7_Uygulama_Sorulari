package com.bilgeadam.memory;

public class StringPool {
    public static void main(String[] args) {

        //String Immutable'dır. Değiştirilemez.
        String str = "Hello";
        System.out.println(str);
        String strConcat = str.concat("World");
        System.out.println(strConcat);

        //String' i mutable yapmak için StringBuffer ve StringBuilder sınıfları vardır.

        StringBuffer stringBuffer = new StringBuffer("abc");
        //System.out.println(stringBuffer);
        stringBuffer.append("def");
        System.out.println("String Buffer: " + stringBuffer);

        StringBuilder stringBuilder = new StringBuilder("ghi");
        stringBuilder.append("jkl");
        System.out.println("String Builder: " + stringBuilder);


        /*StringBuffer ve StringBuilder' ın farkları
        --> StringBuffer synchronized çalışır ve thread-safe'dir
        --> StringBuilder asynchronized çalışır ve thread-safe değildir.

        */
    }
}
