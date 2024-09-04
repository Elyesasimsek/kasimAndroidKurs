package com.example.a003nesnetabanliprogramlama;

import java.util.Scanner;

public class Dilekce {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Öğrenci adını giriniz: ");
        String ogrenciAdi = scanner.next();

        System.out.print("Öğrencinin okul numarasını giriniz: ");
        String okulNo = scanner.next();

        System.out.print("İzin miktarı giriniz: ");
        int izinMiktari = scanner.nextInt();

        System.out.print("Tarih giriniz: ");
        String tarih = scanner.next();

        System.out.print("Velinin adı-soyadını giriniz: ");
        String veliAdi = scanner.next();

        OdevlerSinifi dilekce = new OdevlerSinifi();
        dilekce.dilekceOlustur(ogrenciAdi,okulNo,izinMiktari,tarih,veliAdi);
    }
}
