package com.example.a007ilerijava;

public class TryCatchMethodMain {
    public static void main(String[] args) {
        Hesaplayici hesaplayici = new Hesaplayici();
        try {
            hesaplayici.bol(3,0);
        } catch (Exception e) {
            System.out.println("Sıfıra bölünemez");;
        }
    }
}
