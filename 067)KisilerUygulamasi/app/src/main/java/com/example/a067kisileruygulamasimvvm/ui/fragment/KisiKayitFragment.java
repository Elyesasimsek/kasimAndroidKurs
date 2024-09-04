package com.example.a067kisileruygulamasimvvm.ui.fragment;

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

import com.example.a067kisileruygulamasimvvm.R;
import com.example.a067kisileruygulamasimvvm.databinding.FragmentKisiKayitBinding;
import com.example.a067kisileruygulamasimvvm.ui.viewmodel.KisiKayitViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class KisiKayitFragment extends Fragment {

    private FragmentKisiKayitBinding tasarim;
    private KisiKayitViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_kisi_kayit, container, false);

        tasarim.setKisiKayitFragment(this);
        tasarim.setKisiKayitToolbarBaslik("Kişi Kayıt");

        return tasarim.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(KisiKayitViewModel.class);
    }

    public void buttonKaydet(View v, String kisiAd, String kisiTel){
        viewModel.kayit(kisiAd, kisiTel);
        Navigation.findNavController(v).navigate(R.id.kisiKayitAnasayfaGecis);
    }
}