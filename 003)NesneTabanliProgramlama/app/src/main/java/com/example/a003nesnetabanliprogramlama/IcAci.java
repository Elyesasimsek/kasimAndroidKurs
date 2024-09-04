package com.example.a003nesnetabanliprogramlama;

import java.util.Scanner;

public class IcAci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Kenar sayısı giriniz: ");
        int kenarSayisi = scanner.nextInt();

        OdevlerSinifi icAci = new OdevlerSinifi();
        int sonuc = icAci.icAciToplami(kenarSayisi);
        System.out.println("İç açı toplamı: " + sonuc);
    }
}
