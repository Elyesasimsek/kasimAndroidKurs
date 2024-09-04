package com.example.a001degiskenler;

public class AritmetikIslemler {
    public static void main(String[] args) {
        //dairenin alanı pi*r^2
        double daireAlani, pi = 3.14;
        int yariCap = 2;
        daireAlani = pi * yariCap * yariCap;
        System.out.println("Daire alanı: " + daireAlani);

        //Kuvveti bulma
        int kuvvet, kutle = 67, ivme = 10;
        kuvvet = kutle * ivme;
        System.out.println("Kuvvet: " + kuvvet);

        //yol
        int x1, x2, v0 = 30, v1 = 40, t = 5, a = 2;
        x1 = (v0 + v1)/ 2 * t;
        System.out.println("X: " + x1);

        x2 = (v1 * t) + (a * t * t) / 2;
        System.out.println("X: " + x2);

        int toplam = 80;
        toplam += 20;
        System.out.println("Toplam: " + toplam);

        int sayi1 = 4;
        int sayi2 = ++sayi1;
        int sayi3 = ++sayi1;

        System.out.println("Sayı 1: " + sayi1);
        System.out.println("Sayı 2: " + sayi2);
        System.out.println("Sayı 3: " + sayi3);

    }
}
