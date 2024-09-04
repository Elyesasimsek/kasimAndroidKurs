package com.example.a002standartprogramlamayapilari;

import java.util.Scanner;

public class DongulerIsimTekrarla {
    public static void main(String[] args) {
        Scanner tarayici = new Scanner(System.in);

        System.out.print("İsminizi giriniz: ");
        String isim = tarayici.nextLine();

        System.out.print("Tekrarlama miktarı giriniz: ");
        int sayi = tarayici.nextInt();

        for (int i = 0;i < sayi;i++){
            System.out.println(isim + " - " + (i + 1));
        }
    }
}
