package com.example.a003nesnetabanliprogramlama;

public class MatematikMain {
    public static void main(String[] args) {
        Matematik m1 = new Matematik();

        m1.carpma(3,5);

        int gelenDeger = m1.topla(3,5,8);
        System.out.println("Toplam: " + gelenDeger);

        int elyesa = m1.cikarma(40, 30, "Elyesa");
        System.out.println("Çıkarma: " + elyesa);
    }
}
