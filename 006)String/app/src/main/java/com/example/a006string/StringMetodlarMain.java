package com.example.a006string;

public class StringMetodlarMain {
    public static void main(String[] args) {
        String s1 = "Merhaba Elyesa";
        System.out.println(s1.charAt(8));
        System.out.println(s1.length());
        System.out.println(s1.replace('a', 'e'));
        System.out.println(s1.substring(3, 7));
        System.out.println(s1.toUpperCase());
        System.out.println(s1.toLowerCase());
        System.out.println(s1.trim());
        String[] dizi = s1.split(" ");

        for (String s:dizi){
            System.out.println(s);
        }
    }
}
