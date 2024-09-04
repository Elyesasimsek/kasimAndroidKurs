package com.example.a003nesnetabanliprogramlama;

import java.util.Scanner;

public class HarfBul {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Kelime giriniz: ");
        String kelime = scanner.next();

        System.out.print("Harf giriniz: ");
        char harf = scanner.next().charAt(0);

        OdevlerSinifi harfBul = new OdevlerSinifi();
        harfBul.harfSayisiBul(kelime,harf);
    }
}
