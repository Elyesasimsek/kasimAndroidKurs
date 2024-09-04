package com.example.a003nesnetabanliprogramlama;

import java.util.Scanner;

public class InternetUcreti {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Aylık gb harcamanızı giriniz: ");
        int gb = scanner.nextInt();

        new OdevlerSinifi().internetUcretiHesapla(gb);
    }
}
