package com.example.a045filmleruygulama;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FilmlerAdapter extends RecyclerView.Adapter<FilmlerAdapter.CardTasarimTutucu>{
    private Context mContext;
    private List<Filmler> filmlerList;

    public FilmlerAdapter(Context mContext, List<Filmler> filmlerList) {
        this.mContext = mContext;
        this.filmlerList = filmlerList;
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.film_card_tasarim, parent,false);
        return new CardTasarimTutucu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        Filmler film = filmlerList.get(position);
        holder.textViewFilmAd.setText(film.getFilmAd());
        holder.imageViewFilmResim.setImageResource(mContext.getResources().getIdentifier(film.getFilmResim(), "drawable", mContext.getPackageName()));
        holder.filmCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(mContext, DetayActivity.class);
                intent.putExtra("nesne", film);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return filmlerList.size();
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private CardView filmCard;
        private ImageView imageViewFilmResim;
        private TextView textViewFilmAd;

        public CardTasarimTutucu(@NonNull View itemView) {
            super(itemView);
            filmCard = itemView.findViewById(R.id.filmCard);
            imageViewFilmResim = itemView.findViewById(R.id.imageViewFilmResim);
            textViewFilmAd = itemView.findViewById(R.id.textViewFilmAd);
        }
    }
}
