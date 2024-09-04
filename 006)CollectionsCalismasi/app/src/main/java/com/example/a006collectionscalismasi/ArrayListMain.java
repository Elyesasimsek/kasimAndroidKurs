package com.example.a006collectionscalismasi;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListMain {
    public static void main(String[] args) {
        ArrayList<String> meyveler = new ArrayList<>();
        meyveler.add("Elma");
        meyveler.add("Muz");
        meyveler.add("Portakal");
        System.out.println("Boyut: " + meyveler.size());
        System.out.println(meyveler.get(1));
        meyveler.add("Erik");
        //meyveler.remove("Muz");
        //meyveler.remove(1);
        meyveler.add(1, "Mandalina");
        meyveler.set(3, "Avakado");
        Collections.sort(meyveler);
        for (String s: meyveler)
            System.out.print(s + "  ");
    }
}
