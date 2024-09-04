package com.example.a003nesnetabanliprogramlama;

public class ConstructorMain {
    public static void main(String[] args) {
        Ogrenciler ogrenci  = new Ogrenciler();
        ogrenci.isim = "Elyesa";
        ogrenci.okulNo = "625";
        ogrenci.adres = "Sivas";

        System.out.println(ogrenci.isim);

        Ogrenciler ogrenci2 = new Ogrenciler("Fatma", "658", "Sivas");
        System.out.println(ogrenci2.isim);
    }
}
