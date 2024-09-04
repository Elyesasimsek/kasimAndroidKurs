package com.example.detaylirecyclerviewkullanimi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.cardViewTasarimNesneleriniTutucu>{
    private Context mContext;
    private List<Filmler> filmlerList;

    public FilmAdapter(Context mContext, List<Filmler> filmlerList) {
        this.mContext = mContext;
        this.filmlerList = filmlerList;
    }

    @NonNull
    @Override
    public cardViewTasarimNesneleriniTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_film_tasarim, parent, false);
        return new cardViewTasarimNesneleriniTutucu(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull cardViewTasarimNesneleriniTutucu holder, int position) {
        Filmler film = filmlerList.get(position);
        holder.textViewFilmBaslik.setText(film.getFilmAd());
        holder.textViewFilmFiyat.setText(film.getFilmFiyat() + "TL");
        holder.imageViewFilmResim.setImageResource(mContext.getResources().getIdentifier(film.getFilmResimAd(), "drawable", mContext.getPackageName()));
        holder.buttonSepeteEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, film.getFilmAd() + " sepete eklendi", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return filmlerList.size();
    }

    public class cardViewTasarimNesneleriniTutucu extends RecyclerView.ViewHolder{
        public ImageView imageViewFilmResim;
        public TextView textViewFilmBaslik, textViewFilmFiyat;
        public Button buttonSepeteEkle;

        public cardViewTasarimNesneleriniTutucu(@NonNull View itemView) {
            super(itemView);
            imageViewFilmResim = itemView.findViewById(R.id.imageViewFilmResim);
            textViewFilmBaslik = itemView.findViewById(R.id.textViewFilmBaslik);
            textViewFilmFiyat = itemView.findViewById(R.id.textViewFilmFiyat);
            buttonSepeteEkle = itemView.findViewById(R.id.buttonSepeteEkle);


        }
    }
}
