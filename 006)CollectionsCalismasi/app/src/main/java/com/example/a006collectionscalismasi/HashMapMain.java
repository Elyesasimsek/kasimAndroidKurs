package com.example.a006collectionscalismasi;

import java.util.HashMap;
import java.util.Set;

public class HashMapMain {
    public static void main(String[] args) {
        HashMap<Integer, String> plakalar = new HashMap<>();

        plakalar.put(16, "Bursa");
        plakalar.put(34, "İstanbul");
        plakalar.put(58, "Sivas");

        System.out.println(plakalar.get(58));
        Set<Integer> anahtarlar = plakalar.keySet();

        for (int i: anahtarlar){
            System.out.print(plakalar.get(i) + "  ");
        }

        HashMap<Integer, Ogrenci> nesneler = new HashMap<>();
        Ogrenci ogrenci = new Ogrenci(1111, "Elyesa");
        Ogrenci ogrenci1 = new Ogrenci(2222, "Fatma");
        Ogrenci ogrenci2 = new Ogrenci(3333, "Meryem");

        nesneler.put(ogrenci.getTcNo(), ogrenci);
        nesneler.put(ogrenci1.getTcNo(), ogrenci1);
        nesneler.put(ogrenci2.getTcNo(), ogrenci2);

        Set<Integer> tcNolari = nesneler.keySet();

        for (Integer o:tcNolari) {
            System.out.println("-------------------------");
            System.out.println("Öğrenci TC: " + nesneler.get(o).getTcNo());
            System.out.println("Öğrenci adı: " + nesneler.get(o).getIsim());
        }
    }
}
