package com.example.a003nesnetabanliprogramlama;

import java.util.Scanner;

public class DikdortgenCevre {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dikdörtgenin uzun kenarını giriniz: ");
        int uzunKenar = scanner.nextInt();

        System.out.print("Dikdörtgenin kısa kenarını giriniz: ");
        int kisaKenar = scanner.nextInt();

        OdevlerSinifi cevre = new OdevlerSinifi();
        int gelenSonuc = cevre.cevreHesapla(kisaKenar, uzunKenar);

        System.out.println("Sonuç: " + gelenSonuc);
    }
}
