package com.example.a002standartprogramlamayapilari;

import java.util.Arrays;

public class Diziler {
    public static void main(String[] args) {
        int plakalar[] = new int[5];

        plakalar[0] = 34;
        plakalar[3] = 58;
        plakalar[2] = 45;

        System.out.println(Arrays.toString(plakalar));

        String[] meyveler = {"Elma", "Muz", "Vişne", "Kavun", "Mandalina"};
        double[] boylar = {1.78, 1.85, 1.55, 1.64};

        System.out.println(meyveler[2]);
        double boy = boylar[3];
        System.out.println(boy);
    }
}
