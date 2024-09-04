package com.example.a002standartprogramlamayapilari;

import java.util.Arrays;

public class DizilerSiralama {
    public static void main(String[] args) {
        String isimler[] = {"Elyesa", "Fatma", "Meryem", "Bekir", "Rabia"};

        for (String isim:isimler){
            System.out.println(isim);
        }

        Arrays.sort(isimler);

        for (String isim:isimler){
            System.out.println(isim);
        }
    }
}
