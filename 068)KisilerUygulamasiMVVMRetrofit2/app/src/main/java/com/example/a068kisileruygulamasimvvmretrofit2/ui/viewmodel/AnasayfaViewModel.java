package com.example.a068kisileruygulamasimvvmretrofit2.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.a068kisileruygulamasimvvmretrofit2.data.entity.Kisiler;
import com.example.a068kisileruygulamasimvvmretrofit2.data.repo.KisilerDAORepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class AnasayfaViewModel extends ViewModel {
    private KisilerDAORepository krepo;
    public MutableLiveData<List<Kisiler>> kisilerList = new MutableLiveData<>();

    @Inject
    public AnasayfaViewModel(KisilerDAORepository krepo){
        this.krepo = krepo;
        kisileriYukle();
        kisilerList = krepo.kisileriGetir();
    }

    public void ara(String aramaKelimesi){
        krepo.kisiAra(aramaKelimesi);
    }

    public void kisiSil(int kisiId){
        krepo.kisiSil(kisiId);
    }

    public void kisileriYukle(){
        krepo.tumKisileriAl();
    }
}
