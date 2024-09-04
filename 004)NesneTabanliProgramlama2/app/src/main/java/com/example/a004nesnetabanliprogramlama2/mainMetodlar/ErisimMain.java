package com.example.a004nesnetabanliprogramlama2.mainMetodlar;

import com.example.a004nesnetabanliprogramlama2.siniflar.Ogrenciler;
import com.example.a004nesnetabanliprogramlama2.siniflar.Urunler;

public class ErisimMain {
    public static void main(String[] args) {
        Ogrenciler o1 = new Ogrenciler();
        o1.setIsim("Elyesa");
        o1.setOkulNo("625");

        o1.bilgial();

        Urunler u = new Urunler("Telefon", 30);

        System.out.println(u.getUrunAd());
        System.out.println(u.getUrunAdet());
    }
}
