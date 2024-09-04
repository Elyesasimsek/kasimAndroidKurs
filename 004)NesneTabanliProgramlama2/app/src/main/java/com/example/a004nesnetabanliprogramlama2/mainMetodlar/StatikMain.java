package com.example.a004nesnetabanliprogramlama2.mainMetodlar;

import com.example.a004nesnetabanliprogramlama2.siniflar.Matematik;
import com.example.a004nesnetabanliprogramlama2.siniflar.Personel;

public class StatikMain {
    public static void main(String[] args) {
        int sonuc = Matematik.topla(3,6);
        System.out.println(sonuc);

        Personel p1 = new Personel("Elyesa", 25);
        Personel p2 = new Personel("Fatma", 26);
        Personel p3 = new Personel("Meryem", 0);
        Personel p4 = new Personel("Bekir", 50);
        Personel p5 = new Personel("Rabia", 46);

        System.out.println(Personel.sayac);
    }
}
