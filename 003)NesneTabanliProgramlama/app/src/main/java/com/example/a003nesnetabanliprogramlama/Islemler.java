package com.example.a003nesnetabanliprogramlama;

public class Islemler {
    public double ortalamaHesapla(double... sayilar){
        double toplam = 0;
        double ortalama;

        for (Double d:sayilar){
            toplam += d;
        }
        ortalama = toplam / sayilar.length;
        return ortalama;
    }
}
