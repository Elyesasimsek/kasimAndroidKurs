package com.example.a006collectionscalismasi;

import java.util.HashSet;

public class HashSetMain {
    public static void main(String[] args) {
        HashSet<String> meyveler = new HashSet<>();
        meyveler.add("Elma");
        meyveler.add("Muz");
        meyveler.add("Erik");

        meyveler.remove("Muz");
        meyveler.add("Erik");

        for (String s:meyveler){
            System.out.println(s + "  ");
        }
    }
}
