package com.example.a045filmleruygulama;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class KategoriAdapter extends RecyclerView.Adapter<KategoriAdapter.CardTasarimTutucu>{
    private Context mContext;
    private List<Kategoriler> kategorilerList;

    public KategoriAdapter(Context mContext, List<Kategoriler> kategorilerList) {
        this.mContext = mContext;
        this.kategorilerList = kategorilerList;
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kategori_card_tasarim, parent, false);
        return new CardTasarimTutucu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        Kategoriler kategori = kategorilerList.get(position);
        holder.textViewKategoriAd.setText(kategori.getKategoriAd());
        holder.kategoriCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, FilmlerActivity.class);
                intent.putExtra("kategori_nesne", kategori);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return kategorilerList.size();
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder {
        private CardView kategoriCard;
        private TextView textViewKategoriAd;

        public CardTasarimTutucu(@NonNull View itemView) {
            super(itemView);

            kategoriCard = itemView.findViewById(R.id.kategoriCard);
            textViewKategoriAd = itemView.findViewById(R.id.textViewKategoriAd);

        }
    }
}
