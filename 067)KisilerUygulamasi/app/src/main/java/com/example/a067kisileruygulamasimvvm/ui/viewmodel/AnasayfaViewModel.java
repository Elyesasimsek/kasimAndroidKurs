package com.example.a067kisileruygulamasimvvm.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.a067kisileruygulamasimvvm.data.entity.Kisiler;
import com.example.a067kisileruygulamasimvvm.data.repo.KisilerDAORepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class AnasayfaViewModel extends ViewModel {

    private KisilerDAORepository krepo;

    @Inject
    public AnasayfaViewModel(KisilerDAORepository krepo){
        this.krepo = krepo;
        kisileriYukle();
        kisilerList = krepo.kisileriGetir();
    }

    public MutableLiveData<List<Kisiler>> kisilerList = new MutableLiveData<>();

    public void ara(String aramaKelimesi){
        krepo.kisiAra(aramaKelimesi);
    }

    public void sil(int kisId){
        krepo.kisiSil(kisId);
    }

    public void kisileriYukle(){
        krepo.tumKisileriAl();
    }
}
