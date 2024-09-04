package com.example.a005nesnetabanliprogramlama;

public class CastingMain {
    public static void main(String[] args) {
        //up
        Subaru subaru = new Subaru();
        Araba araba = subaru;
        //down
        Araba araba1 = new Araba();
        Subaru subaru1 = (Subaru) araba1;


    }
}
