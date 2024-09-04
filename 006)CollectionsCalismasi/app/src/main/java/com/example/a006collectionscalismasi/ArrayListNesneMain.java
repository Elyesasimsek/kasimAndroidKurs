package com.example.a006collectionscalismasi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListNesneMain {
    public static void main(String[] args) {
        List<Ogrenci> nesneler = new ArrayList<>();
        Ogrenci ogrenci = new Ogrenci(1111, "Elyesa");
        Ogrenci ogrenci1 = new Ogrenci(2222, "Fatma");
        Ogrenci ogrenci2 = new Ogrenci(3333, "Meryem");

        nesneler.add(ogrenci);
        nesneler.add(ogrenci1);
        nesneler.add(ogrenci2);

        Collections.sort(nesneler);

        for (Ogrenci o:nesneler){
            System.out.println("-------------------------");
            System.out.println("Öğrenci TC: " + o.getTcNo());
            System.out.println("Öğrenci adı: " + o.getIsim());
        }
    }
}
