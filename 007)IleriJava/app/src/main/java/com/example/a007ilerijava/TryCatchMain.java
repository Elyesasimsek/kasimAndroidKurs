package com.example.a007ilerijava;

public class TryCatchMain {
    public static void main(String[] args) {
        int x = 5;
        int y = 1;
        int[] dizi = new int[2];
        try {
            System.out.println("Sonuç: " + (x / y));
            System.out.println("İşlem tamam");
            dizi[4] = 8;
        }catch (Exception e){
            if (e instanceof ArithmeticException) {
                System.out.println("Sayılar 0'a bölünmez.");
            }
            if (e instanceof ArrayIndexOutOfBoundsException){
                System.out.println("Dizinin boyutunu aştınız");
            }
        }
    }
}
