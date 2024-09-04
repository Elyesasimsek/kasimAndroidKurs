package com.example.a002standartprogramlamayapilari;

import java.util.Scanner;

public class WhileVeriIsleme {
    public static void main(String[] args) {
        Scanner tarayici = new Scanner(System.in);

        System.out.print("İşlenecek veri miktarını giriniz: ");
        int sayi = tarayici.nextInt();

        while (sayi > 0){
            System.out.println("işlenen veri: " + sayi);
            sayi--;
        }
    }
}
