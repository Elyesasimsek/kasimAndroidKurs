package com.example.a065roomkullanimi;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "kisiler")
public class Kisiler {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "kisiId")
    @NotNull
    private int kisiId;
    @ColumnInfo(name = "kisiAd")
    @NotNull
    private String kisiAd;
    @ColumnInfo(name = "kisiYas")
    @NotNull
    private int kisiYas;

    public Kisiler() {
    }

    public Kisiler(int kisiId, @NotNull String kisiAd, int kisiYas) {
        this.kisiId = kisiId;
        this.kisiAd = kisiAd;
        this.kisiYas = kisiYas;
    }

    public int getKisiId() {
        return kisiId;
    }

    public void setKisiId(int kisiId) {
        this.kisiId = kisiId;
    }

    @NotNull
    public String getKisiAd() {
        return kisiAd;
    }

    public void setKisiAd(@NotNull String kisiAd) {
        this.kisiAd = kisiAd;
    }

    public int getKisiYas() {
        return kisiYas;
    }

    public void setKisiYas(int kisiYas) {
        this.kisiYas = kisiYas;
    }
}
