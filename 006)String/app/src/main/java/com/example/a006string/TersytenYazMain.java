package com.example.a006string;

import java.util.Scanner;

public class TersytenYazMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Lütfen kelime giriniz: ");
        String gelenKelime = scanner.next();

        int boyut = gelenKelime.length();
        char[] dizi = new char[boyut];

        for (int i = 0;i < boyut;i++){
            dizi[i] = gelenKelime.charAt(i);
        }

        for (int i = boyut - 1;i >= 0;i--){
            System.out.print(dizi[i]);
        }
    }
}
