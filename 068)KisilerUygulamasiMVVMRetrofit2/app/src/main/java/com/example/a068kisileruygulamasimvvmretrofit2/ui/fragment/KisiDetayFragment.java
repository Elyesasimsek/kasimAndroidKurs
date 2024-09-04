package com.example.a068kisileruygulamasimvvmretrofit2.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a068kisileruygulamasimvvmretrofit2.R;
import com.example.a068kisileruygulamasimvvmretrofit2.data.entity.Kisiler;
import com.example.a068kisileruygulamasimvvmretrofit2.databinding.FragmentKisiDetayBinding;
import com.example.a068kisileruygulamasimvvmretrofit2.ui.viewmodel.KisiDetayViewModel;
import com.example.a068kisileruygulamasimvvmretrofit2.ui.viewmodel.KisiKayitViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class KisiDetayFragment extends Fragment {
    private FragmentKisiDetayBinding tasarim;
    private KisiDetayViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        tasarim =  DataBindingUtil.inflate(inflater, R.layout.fragment_kisi_detay, container, false);
        tasarim.setKisiDetayFragment(this);
        tasarim.setKisiDetayToolbarBaslik("Kişi Detay");

        KisiDetayFragmentArgs bundle = KisiDetayFragmentArgs.fromBundle(getArguments());
        Kisiler gelenKisi = bundle.getKisi();

        tasarim.setKisiNesnesi(gelenKisi);

        return tasarim.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(KisiDetayViewModel.class);
    }

    public void buttonGuncelle(View view, int kisiId, String kisiAd, String kisiTel){
        viewModel.guncelle(kisiId, kisiAd, kisiTel);
        Navigation.findNavController(view).navigate(R.id.kisiDetayAnasayfaGecis);
    }
}