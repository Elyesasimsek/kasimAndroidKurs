package com.example.a067kisileruygulamasimvvm.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

@Entity(tableName = "kisiler")
public class Kisiler implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "kisiId")
    @NotNull
    private int kisiId;
    @ColumnInfo(name = "kisiAd")
    @NotNull
    private String kisiAd;
    @ColumnInfo(name = "kisiTel")
    @NotNull
    private String kisiTel;

    public Kisiler() {
    }

    public Kisiler(@NotNull int kisiId, @NotNull String kisiAd, @NotNull String kisiTel) {
        this.kisiId = kisiId;
        this.kisiAd = kisiAd;
        this.kisiTel = kisiTel;
    }

    @NotNull
    public int getKisiId() {
        return kisiId;
    }

    public void setKisiId(@NotNull int kisiId) {
        this.kisiId = kisiId;
    }

    public @NotNull String getKisiAd() {
        return kisiAd;
    }

    public void setKisiAd(@NotNull String kisiAd) {
        this.kisiAd = kisiAd;
    }

    public @NotNull String getKisiTel() {
        return kisiTel;
    }

    public void setKisiTel(@NotNull String kisiTel) {
        this.kisiTel = kisiTel;
    }
}
