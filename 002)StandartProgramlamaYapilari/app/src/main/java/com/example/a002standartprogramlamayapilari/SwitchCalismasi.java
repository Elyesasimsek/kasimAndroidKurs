package com.example.a002standartprogramlamayapilari;

public class SwitchCalismasi {
    public static void main(String[] args) {
        int gun = 3;
        switch (gun){
            case 1:
                System.out.println("Pazartesi");
                break;
            case 2:
                System.out.println("Salı");
                break;
            case 3:
                System.out.println("Çarşamba");
                break;
            case 4:
                System.out.println("Perşembe");
                break;
            default:
                System.out.println("Böyle bir gün yok");
                break;
        }
    }
}
