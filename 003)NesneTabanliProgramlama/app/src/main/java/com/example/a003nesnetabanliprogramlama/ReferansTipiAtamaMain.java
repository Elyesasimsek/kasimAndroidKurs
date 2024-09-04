package com.example.a003nesnetabanliprogramlama;

public class ReferansTipiAtamaMain {
    public static void main(String[] args) {
        Ogrenciler ogrenci1 = new Ogrenciler();
        ogrenci1.isim = "Elyesa";
        System.out.println(ogrenci1.isim);

        Ogrenciler ogrenci2 = ogrenci1;
        ogrenci2.isim = "Fatma";
        System.out.println(ogrenci1.isim);

        System.out.println(ogrenci1.hashCode());
        System.out.println(ogrenci2.hashCode());
    }
}
