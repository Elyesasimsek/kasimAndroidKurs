package com.example.a002standartprogramlamayapilari;

import java.util.Random;

public class HazirKomutlar {
    public static void main(String[] args) {
        int i = -5;

        System.out.println("Mutlak değer: " + Math.abs(i));
        System.out.println("Pi: " + Math.PI);
        System.out.println("Üslü sayılar: " + Math.pow(2, 3));
        System.out.println("Köklü sayılar: " + Math.sqrt(9));

        Random random = new Random();


        for (int k = 0;k < 5;k++) {
            int sayi = random.nextInt(10);
            System.out.println(sayi);
        }
    }

}
