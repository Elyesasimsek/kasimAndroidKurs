package com.example.a005nesnetabanliprogramlama;

public class EqualsToStringMain {
    public static void main(String[] args) {
        Ogrenci ogrenci1 = new Ogrenci(111, "Elyesa");
        Ogrenci ogrenci2 = new Ogrenci(222, "Fatma");
        Ogrenci ogrenci3 = new Ogrenci(333, "Meryem");
        Ogrenci ogrenci4 = new Ogrenci(444,"Elyesa");

        System.out.println(ogrenci1);
        System.out.println(ogrenci2);
        System.out.println(ogrenci3);
        System.out.println(ogrenci4);

        if (ogrenci1.equals(ogrenci3)){
            System.out.println("Eşit");
        }else {
            System.out.println("Eşit değil");
        }
    }
}
