package com.example.a001degiskenler;

import java.util.Scanner;

public class KonsolGirdi {
    public static void main(String[] args) {
        Scanner tarayici = new Scanner(System.in);
        System.out.print("Lütfen adınızı Giriniz: ");
        String gelenAd = tarayici.next();
        System.out.print("Lütfen yaşınızı giriniz: ");
        int gelenYas = tarayici.nextInt();
        System.out.print("Lütfen boyunuzu giriniz: ");
        double gelenBoy = tarayici.nextDouble();
        System.out.print("Evli misiniz: ");
        boolean evlimi = tarayici.nextBoolean();

        System.out.println("Ad: " + gelenAd);
        System.out.println("Yaş: " + gelenYas);
        System.out.println("Boy: " + gelenBoy);
        System.out.println("Evlimi: " + evlimi);
    }
}
