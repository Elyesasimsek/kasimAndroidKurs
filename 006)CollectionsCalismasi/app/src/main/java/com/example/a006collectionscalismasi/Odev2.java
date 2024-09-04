package com.example.a006collectionscalismasi;

import java.util.ArrayList;
import java.util.Scanner;

public class Odev2 {
    public static void main(String[] args) {
        ArrayList<String> isimler = new ArrayList<>();

        isimler.add("Elyesa");
        isimler.add("Fatma");
        isimler.add("Meryem");
        isimler.add("Bekir");
        isimler.add("Rabia");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Arama ismini gir:");
        String isim = scanner.next();

        for (String s:isimler){
            if (s.equalsIgnoreCase(isim)){
                System.out.println("İsim mevcut");
                break;
            }else {
                System.out.println("İsim mevcut değil");
                break;
            }
        }
    }
}
