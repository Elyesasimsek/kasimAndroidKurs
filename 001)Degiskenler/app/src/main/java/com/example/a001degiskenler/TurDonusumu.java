package com.example.a001degiskenler;

public class TurDonusumu {
    public static void main(String[] args) {
        double d = 23.56;
        long l = (long)d;
        int i = (int)l;
        System.out.println("Double değer: " + d );
        System.out.println("Long değer: " + l);
        System.out.println("İnt değer: " + i);

        int x = 67;
        long y = x;
        double z = y;
        System.out.println("X değer: " + x);
        System.out.println("Y değer: " + y);
        System.out.println("Z değer: " + z);

        int sayi = 56;
        String yazi1 = String.valueOf(sayi);
        System.out.println("Yazı: " + yazi1);

        String metin = "58";
        int sayi1 = Integer.parseInt(metin);
        System.out.println("Sayi: " + sayi1);
    }
}
