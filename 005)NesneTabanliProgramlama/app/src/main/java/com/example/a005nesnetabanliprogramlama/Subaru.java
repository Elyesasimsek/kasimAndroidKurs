package com.example.a005nesnetabanliprogramlama;

public class Subaru extends Araba {
    private String motorHacmi;

    public Subaru() {
        super( "sedan");
        System.out.println("Subaru boş constructor çalıştı");
    }

    public Subaru(String motorHacmi) {
        super();
        System.out.println("Subaru dolu constructor çalıştı");
        this.motorHacmi = motorHacmi;
    }



    public String getMotorHacmi() {
        return motorHacmi;
    }

    public void setMotorHacmi(String motorHacmi) {
        this.motorHacmi = motorHacmi;
    }
}
