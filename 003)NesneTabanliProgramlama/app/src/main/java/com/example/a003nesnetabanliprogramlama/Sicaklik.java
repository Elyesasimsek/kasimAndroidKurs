package com.example.a003nesnetabanliprogramlama;

import java.util.Scanner;

public class Sicaklik {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Sıcaklık derecesini giriniz: ");
        double sicaklik = scanner.nextDouble();

        OdevlerSinifi sicaklikSinifi = new OdevlerSinifi();
        sicaklikSinifi.SicaklikDonustur(sicaklik);
    }
}
