package com.example.a042sozlukuygulamasi;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class KelimelerDAO {
    public ArrayList<Kelimeler> tumKelimeler(Veritabani vt){
        ArrayList<Kelimeler> kelimelerArrayList = new ArrayList<>();

        SQLiteDatabase db = vt.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM kelimeler", null);
        while (cursor.moveToNext()){
            @SuppressLint("Range") Kelimeler k = new Kelimeler(cursor.getInt(cursor.getColumnIndex("kelime_id")),
                    cursor.getString(cursor.getColumnIndex("ingilizce")),
                    cursor.getString(cursor.getColumnIndex("turkce")));
            kelimelerArrayList.add(k);
        }
        return kelimelerArrayList;
    }

    public ArrayList<Kelimeler> kelimeAra(Veritabani vt, String aramaKelime){
        ArrayList<Kelimeler> kelimelerArrayList = new ArrayList<>();

        SQLiteDatabase db = vt.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM kelimeler WHERE ingilizce like '%" + aramaKelime + "%'", null);
        while (cursor.moveToNext()){
            @SuppressLint("Range") Kelimeler k = new Kelimeler(cursor.getInt(cursor.getColumnIndex("kelime_id")),
                    cursor.getString(cursor.getColumnIndex("ingilizce")),
                    cursor.getString(cursor.getColumnIndex("turkce")));
            kelimelerArrayList.add(k);
        }
        return kelimelerArrayList;
    }
}
