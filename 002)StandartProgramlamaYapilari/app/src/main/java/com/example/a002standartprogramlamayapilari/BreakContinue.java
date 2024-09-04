package com.example.a002standartprogramlamayapilari;

public class BreakContinue {
    public static void main(String[] args) {
        for (int i = 0;i <= 5;i++){
            System.out.println("İndex: " + i);
            if (i == 3)
                break;
        }

        for (int i = 0;i <= 5;i++){
            System.out.println("İndex: " + i);
            if (i == 3)
                continue;
        }
    }
}
