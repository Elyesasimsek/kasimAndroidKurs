package com.example.a043notlaruygulamasi;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class NotlarDAO {
    public ArrayList<Notlar> tumNotlar(Veritabani vt){
        ArrayList<Notlar> notlarArrayList = new ArrayList<>();
        SQLiteDatabase db = vt.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM notlar", null);
        while (cursor.moveToNext()){
            @SuppressLint("Range") Notlar n = new Notlar(cursor.getInt(cursor.getColumnIndex("notId")),
                    cursor.getString(cursor.getColumnIndex("dersAdi")),
                    cursor.getInt(cursor.getColumnIndex("not1")),
                    cursor.getInt(cursor.getColumnIndex("not2")));
            notlarArrayList.add(n);
        }
        db.close();
        return notlarArrayList;
    }

    public void notSil(Veritabani vt, int notId){
        SQLiteDatabase db = vt.getWritableDatabase();
        db.delete("notlar", "notId=?", new String[]{String.valueOf(notId)});
        db.close();
    }

    public void notEkle(Veritabani vt, String dersAdi, int not1, int not2){
        SQLiteDatabase db = vt.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("dersAdi", dersAdi);
        values.put("not1", not1);
        values.put("not2", not2);

        db.insertOrThrow("notlar", null, values);
        db.close();
    }

    public void notDuzenle(Veritabani vt, int notId, String dersAdi, int not1, int not2){
        SQLiteDatabase db = vt.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("dersAdi", dersAdi);
        values.put("not1", not1);
        values.put("not2", not2);

        db.update("notlar",  values, "notId=?", new String[]{String.valueOf(notId)});
        db.close();
    }
}
