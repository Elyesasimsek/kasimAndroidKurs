package com.example.a003nesnetabanliprogramlama;

import java.util.Scanner;

public class Faktoriyel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Faktoriyel hesabı için sayı giriniz: ");
        int sayi = scanner.nextInt();

        OdevlerSinifi faktoriyel = new OdevlerSinifi();
        int faktoriyelSonuc = faktoriyel.faktoriyel(sayi);

        System.out.println("Foktoriyel sonuç: " + faktoriyelSonuc);
    }
}
