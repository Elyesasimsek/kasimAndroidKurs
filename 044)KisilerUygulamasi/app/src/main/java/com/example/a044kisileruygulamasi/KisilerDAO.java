package com.example.a044kisileruygulamasi;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class KisilerDAO {
    public ArrayList<Kisiler> tumKisiler(Veritabani vt){
        ArrayList<Kisiler> kisilerArrayList = new ArrayList<>();
        SQLiteDatabase db = vt.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM kisiler", null);
        while (c.moveToNext()){
            @SuppressLint("Range") Kisiler k = new Kisiler(c.getInt(c.getColumnIndex("kisiId")),
                    c.getString(c.getColumnIndex("kisiAd")),
                    c.getString(c.getColumnIndex("kisiTel")));
            kisilerArrayList.add(k);
        }
        db.close();
        return kisilerArrayList;
    }

    public ArrayList<Kisiler> kisiAra(Veritabani vt, String aramaKelime){
        ArrayList<Kisiler> kisilerArrayList = new ArrayList<>();
        SQLiteDatabase db = vt.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM kisiler WHERE kisiAd like '%" + aramaKelime + "%'", null);
        while (c.moveToNext()){
            @SuppressLint("Range") Kisiler k = new Kisiler(c.getInt(c.getColumnIndex("kisiId")),
                    c.getString(c.getColumnIndex("kisiAd")),
                    c.getString(c.getColumnIndex("kisiTel")));
            kisilerArrayList.add(k);
        }
        db.close();
        return kisilerArrayList;
    }

    public void KisiSil(Veritabani vt, int kisiId){
        SQLiteDatabase db = vt.getWritableDatabase();
        db.delete("kisiler", "kisiId=?", new String[]{String.valueOf(kisiId)});
        db.close();
    }

    public void KisiEkle(Veritabani vt, String kisiAd, String kisiTel){
        SQLiteDatabase db = vt.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("kisiAd", kisiAd);
        values.put("kisiTel", kisiTel);
        db.insertOrThrow("kisiler", null, values);
        db.close();
    }

    public void KisiGuncelle(Veritabani vt, int kisiId, String kisiAd, String kisiTel){
        SQLiteDatabase db = vt.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("kisiAd", kisiAd);
        values.put("kisiTel", kisiTel);
        db.update("kisiler", values, "kisiId=?", new String[]{String.valueOf(kisiId)});
        db.close();
    }
}
