package com.example.a068kisileruygulamasimvvmretrofit2.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a068kisileruygulamasimvvmretrofit2.R;
import com.example.a068kisileruygulamasimvvmretrofit2.data.entity.Kisiler;
import com.example.a068kisileruygulamasimvvmretrofit2.databinding.CardTasarimBinding;
import com.example.a068kisileruygulamasimvvmretrofit2.ui.fragment.AnasayfaFragmentDirections;
import com.example.a068kisileruygulamasimvvmretrofit2.ui.viewmodel.AnasayfaViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class KisilerAdapter extends RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu>{
    private Context mContext;
    private List<Kisiler> kisilerList;
    private AnasayfaViewModel viewModel;

    public KisilerAdapter(Context mContext, List<Kisiler> kisilerList, AnasayfaViewModel viewModel) {
        this.mContext = mContext;
        this.kisilerList = kisilerList;
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        CardTasarimBinding tasarim = DataBindingUtil.inflate(layoutInflater, R.layout.card_tasarim, parent, false);
        return new CardTasarimTutucu(tasarim);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        Kisiler kisi = kisilerList.get(position);
        CardTasarimBinding t = holder.tasarim;
        t.setKisiNesnesi(kisi);
        t.imageViewSil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, kisi.getKisiAd() + " silinsin mi?", Snackbar.LENGTH_LONG).setAction("Evet", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        viewModel.kisiSil(kisi.getKisiId());
                    }
                }).show();
            }
        });
        t.satirCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnasayfaFragmentDirections.KisiDetayGecis gecis = AnasayfaFragmentDirections.kisiDetayGecis(kisi);
                Navigation.findNavController(v).navigate(gecis);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (kisilerList == null){
            return 0;
        }else {
            return kisilerList.size();
        }
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private CardTasarimBinding tasarim;

        public CardTasarimTutucu(CardTasarimBinding tasarim) {
            super(tasarim.getRoot());
            this.tasarim = tasarim;
        }
    }
}
