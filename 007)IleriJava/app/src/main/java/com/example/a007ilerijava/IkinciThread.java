package com.example.a007ilerijava;

public class IkinciThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0;i <100;i++){
            System.out.println("İkinci Thread: " + i);
        }
    }
}
