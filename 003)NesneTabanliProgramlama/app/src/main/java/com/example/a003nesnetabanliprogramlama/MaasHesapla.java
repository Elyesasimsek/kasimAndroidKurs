package com.example.a003nesnetabanliprogramlama;

import java.util.Scanner;

public class MaasHesapla {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Çalışma gün sayınızı giriniz: ");
        int gun = scanner.nextInt();

        int sonuc = new OdevlerSinifi().maasHesapla(gun);

        System.out.println("Maaş: " + sonuc);
    }
}
