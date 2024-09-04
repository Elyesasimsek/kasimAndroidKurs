package com.example.a005nesnetabanliprogramlama;

public class Elma implements Eatable,Squueezable{
    @Override
    public void howToEat() {
        System.out.println("Yıka ve ye");
    }

    @Override
    public void howToSqueeze() {
        System.out.println("Soy ve suyunu çıkar");
    }
}
