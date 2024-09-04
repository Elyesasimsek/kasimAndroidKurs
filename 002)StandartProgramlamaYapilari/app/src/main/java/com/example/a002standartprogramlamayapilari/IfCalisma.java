package com.example.a002standartprogramlamayapilari;

public class IfCalisma {
    public static void main(String[] args) {
        int yas = 25;
        String isim = "Elyesa";
        if (yas >= 18){
            System.out.println("Reşitsiniz.");
        }else {
            System.out.println("Reşit Değilsiniz.");
        }
        if (isim.equals("Fatma")){
            System.out.println("Merhaba Fatma.");
        } else if (isim.equals("Meryem")) {
            System.out.println("Merhaba Meryem");
        } else {
            System.out.println("Merhaba kimse.");
        }
        int sifre = 1234;
        String kullaniciAdi = "admin";
        if (sifre == 1234 && kullaniciAdi.equals("admin")){
            System.out.println("Merhaba " + kullaniciAdi);
        }else {
            System.out.println("Hatalı Giriş");
        }

        int sinif = 11;
        if (sinif == 9 || sinif == 10 || sinif == 11 || sinif == 12){
            System.out.println("YGS sınavına hazırlan.");
        } else if (sinif == 6 || sinif == 7 || sinif == 8) {
            System.out.println("LGS sınavına hazırlan.");
        }
    }
}
