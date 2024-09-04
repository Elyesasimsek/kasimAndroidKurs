package com.example.sozlukuygulamasi;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class KelimelerDAO {
    public void kelimeEkle(VeritabaniYardimcisi veritabaniYardimcisi, String ingilizce, String turkce){
        SQLiteDatabase db = veritabaniYardimcisi.getWritableDatabase();
        ContentValues degerler = new ContentValues();

        degerler.put("ingilizce", ingilizce);
        degerler.put("turkce", turkce);

        db.insertOrThrow("kelimeler", null, degerler);
        db.close();
    }

    public ArrayList<Kelimeler> tumKelimeler(VeritabaniYardimcisi veritabaniYardimcisi){
        ArrayList<Kelimeler> kelimelerArrayList = new ArrayList<>();
        SQLiteDatabase db = veritabaniYardimcisi.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM kelimeler", null);
        while (cursor.moveToNext()){
            @SuppressLint("Range") Kelimeler kelime = new Kelimeler(cursor.getInt(cursor.getColumnIndex("kelimeId")), cursor.getString(cursor.getColumnIndex("ingilizce")), cursor.getString(cursor.getColumnIndex("turkce")));
            kelimelerArrayList.add(kelime);
        }
        return  kelimelerArrayList;
    }

    public void kelimeSil(VeritabaniYardimcisi veritabaniYardimcisi, int kelimeId){
        SQLiteDatabase db = veritabaniYardimcisi.getWritableDatabase();
        db.delete("kelimeler", "kelimeId = ?", new String[]{
                String.valueOf(kelimeId)
        });
        db.close();
    }

    public void kelimeGuncelle(VeritabaniYardimcisi veritabaniYardimcisi,int kelimeId, String ingilizce, String turkce){
        SQLiteDatabase db = veritabaniYardimcisi.getWritableDatabase();
        ContentValues degerler = new ContentValues();

        degerler.put("ingilizce", ingilizce);
        degerler.put("turkce", turkce);

        db.update("kelimeler", degerler, "kelimeId = ?", new String[]{
                String.valueOf(kelimeId)
        });
        db.close();
    }

    @SuppressLint("Range")
    public int kayitKontrol(VeritabaniYardimcisi veritabaniYardimcisi){
        int sonuc = 8;
        SQLiteDatabase db = veritabaniYardimcisi.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT count(*) as sonuc FROM kelimeler", null);
        while (cursor.moveToNext()){
            sonuc = cursor.getInt(cursor.getColumnIndex("sonuc"));
        }
        return sonuc;
    }

    public Kelimeler kelimeGetir(VeritabaniYardimcisi veritabaniYardimcisi, int kelimeId){
        Kelimeler kelime = new Kelimeler();
        SQLiteDatabase db = veritabaniYardimcisi.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM kelimeler WHERE kelimeId = ?" + kelimeId, null);
        while (cursor.moveToNext()){
            @SuppressLint("Range") Kelimeler k = new Kelimeler(cursor.getInt(cursor.getColumnIndex("kelimeId")), cursor.getString(cursor.getColumnIndex("ingilizce")), cursor.getString(cursor.getColumnIndex("turkce")));
            kelime = k;
        }
        return kelime;
    }

    public ArrayList<Kelimeler> tumKelimelerRastgele2(VeritabaniYardimcisi veritabaniYardimcisi){
        ArrayList<Kelimeler> kelimelerArrayList = new ArrayList<>();
        SQLiteDatabase db = veritabaniYardimcisi.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM kelimeler ORDER BY RANDOM() LIMIT 2", null);
        while (cursor.moveToNext()){
            @SuppressLint("Range") Kelimeler kelime = new Kelimeler(cursor.getInt(cursor.getColumnIndex("kelimeId")), cursor.getString(cursor.getColumnIndex("ingilizce")), cursor.getString(cursor.getColumnIndex("turkce")));
            kelimelerArrayList.add(kelime);
        }
        return  kelimelerArrayList;
    }

    public ArrayList<Kelimeler> kelimeAra(VeritabaniYardimcisi veritabaniYardimcisi, String keyWord){
        ArrayList<Kelimeler> kelimelerArrayList = new ArrayList<>();
        SQLiteDatabase db = veritabaniYardimcisi.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM kelimeler WHERE ingilizce like '%" + keyWord +"%'", null);
        while (cursor.moveToNext()){
            @SuppressLint("Range") Kelimeler kelime = new Kelimeler(cursor.getInt(cursor.getColumnIndex("kelimeId")), cursor.getString(cursor.getColumnIndex("ingilizce")), cursor.getString(cursor.getColumnIndex("turkce")));
            kelimelerArrayList.add(kelime);
        }
        return  kelimelerArrayList;
    }
}
