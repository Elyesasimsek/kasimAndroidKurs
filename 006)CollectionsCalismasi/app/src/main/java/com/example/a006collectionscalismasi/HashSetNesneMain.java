package com.example.a006collectionscalismasi;

import java.util.HashSet;

public class HashSetNesneMain {
    public static void main(String[] args) {
        HashSet<Ogrenci> nesneler = new HashSet<>();
        Ogrenci ogrenci = new Ogrenci(1111, "Elyesa");
        Ogrenci ogrenci1 = new Ogrenci(2222, "Fatma");
        Ogrenci ogrenci2 = new Ogrenci(3333, "Meryem");

        nesneler.add(ogrenci);
        nesneler.add(ogrenci1);
        nesneler.add(ogrenci2);


        for (Ogrenci o:nesneler) {
            System.out.println("-------------------------");
            System.out.println("Öğrenci TC: " + o.getTcNo());
            System.out.println("Öğrenci adı: " + o.getIsim());
        }
    }
}
