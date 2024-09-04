package com.example.a067kisileruygulamasimvvm.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.a067kisileruygulamasimvvm.data.entity.Kisiler;

@Database(entities = {Kisiler.class}, version = 1)
public abstract class Veritabani extends RoomDatabase {
    public abstract KisilerDAO getKisilerDAO();
}
