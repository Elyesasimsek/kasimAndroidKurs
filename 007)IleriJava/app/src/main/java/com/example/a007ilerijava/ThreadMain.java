package com.example.a007ilerijava;

public class ThreadMain {
    public static void main(String[] args) {

        BirinciThread birinciThread = new BirinciThread();
        birinciThread.start();

        Thread bt2 = new Thread(new IkinciThread());
        bt2.start();

        for (int i = 0;i <100;i++){
            System.out.println("Main: " + i);
        }
    }

    static class BirinciThread extends Thread{
        public void run (){
            for (int i = 0;i <100;i++){
                System.out.println("Birinci Thread: " + i);
            }
        }
    }
}
