package com.example.a067kisileruygulamasimvvm.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.a067kisileruygulamasimvvm.data.repo.KisilerDAORepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class KisiDetayViewModel extends ViewModel {

    private KisilerDAORepository krepo;

    @Inject
    public KisiDetayViewModel(KisilerDAORepository krepo){
        this.krepo = krepo;
    }

    public void guncelle(int kisiId, String kisiAd, String kisiTel){
        krepo.kisiGuncelle(kisiId, kisiAd, kisiTel);
    }
}
