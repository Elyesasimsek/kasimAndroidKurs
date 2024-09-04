package com.example.a008javaiouygulamalari;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class JavaIOMain {
    public static void main(String[] args) {
        //fileWriteYaz();
        //fileReadOku();
        //oswYaz();
        //isrOku();
        //bufferYaz();
        bufferOku();
    }

    public static void bufferYaz(){
        try {
            File dosya = new File("C:\\Users\\rabiy\\OneDrive\\Masaüstü\\dosyaBuffer.txt");
            if (!dosya.exists()) {
                dosya.createNewFile();
            }
            FileWriter fw = new FileWriter(dosya);
            BufferedWriter yazici = new BufferedWriter(fw);
            yazici.write("sfjdıkbjfslkcxbhkjkljoıfsxcjfolk");
            yazici.flush();
            yazici.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void bufferOku(){
        try {
            File dosya = new File("C:\\Users\\rabiy\\OneDrive\\Masaüstü\\dosyaBuffer.txt");
            FileReader fr = new FileReader(dosya);
            BufferedReader okuyucu = new BufferedReader(fr);
            StringBuilder sb = new StringBuilder();
            String satir = "";
            while ((satir = okuyucu.readLine()) != null){
                sb.append(satir + "\n");
            }

            okuyucu.close();
            System.out.println(sb.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void oswYaz(){
        try {
            File dosya = new File("C:\\Users\\rabiy\\OneDrive\\Masaüstü\\dosya.txt");
            if (!dosya.exists()) {
                dosya.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(dosya);
            OutputStreamWriter yazici = new OutputStreamWriter(fos, "utf-8");
            yazici.write("Merhaba foss");
            yazici.flush();
            yazici.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void isrOku() {
        try {
            File dosya = new File("C:\\Users\\rabiy\\OneDrive\\Masaüstü\\dosya.txt");
            FileInputStream fis = new FileInputStream(dosya);
            InputStreamReader okuyucu = new InputStreamReader(fis, "utf-8");

            StringBuilder sp = new StringBuilder();
            int bilgi = 0;

            while ((bilgi = okuyucu.read()) != -1) {
                sp.append((char) bilgi);
            }
            okuyucu.close();
            System.out.println("Okunan: " + sp.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fileWriteYaz(){
            try {
                File dosya = new File("C:\\Users\\rabiy\\OneDrive\\Masaüstü\\dosya.txt");
                if (!dosya.exists()) {
                    dosya.createNewFile();
                }
                FileWriter yazici  = new FileWriter(dosya);
                yazici.write("Merhaba");
                yazici.flush();
                yazici.close();
                dosya.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }

    public static void fileReadOku(){
        try {
            File dosya = new File("C:\\Users\\rabiy\\OneDrive\\Masaüstü\\dosya.txt");
            FileReader okuyucu = new FileReader(dosya);

            StringBuilder sp = new StringBuilder();
            int bilgi = 0;

            while ((bilgi = okuyucu.read()) != -1){
                sp.append((char)bilgi);
            }
            okuyucu.close();
            System.out.println("Okunan: " + sp.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}