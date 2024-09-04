package com.example.a001degiskenler;

public class StringBirlestirme {
    public static void main(String[] args) {
        String yazi = "Elyesa ";
        String sonuc = yazi + "merhaba";
        System.out.println(sonuc);
        String str = "Kişinin adı: " + "Fatma";
        System.out.println(str);
        int not = 100;
        String ders = "matematik";
        String ogrenciAdi = "Meryem ";
        String metin = ogrenciAdi + ders +" sınavından "+ not + " aldı.";
        System.out.println(metin);
        int sayi1 = 50;
        int sayi2 = 40;
        System.out.println("Sayı 1: " + sayi1);
        System.out.println("Sayı 2: " + sayi2);
        System.out.println("Sonuç: " + (sayi1 + sayi2));
    }
}
