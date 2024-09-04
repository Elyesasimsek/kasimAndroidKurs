package com.example.a059filmleruygulamavolley;

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

import com.squareup.picasso.Picasso;

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
        String url = "https://elyesasimsek.com/filmler/resimler/" + film.getFilmResim();
        Picasso.get().load(url).into(holder.imageViewFilmResim);
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
        if (filmlerList == null) {
            return 0;
        } else {
            return filmlerList.size();
        }
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private ImageView imageViewFilmResim;
        private TextView textViewFilmAd;
        private CardView filmCard;

        public CardTasarimTutucu(@NonNull View itemView) {
            super(itemView);
            filmCard = itemView.findViewById(R.id.filmCard);
            imageViewFilmResim = itemView.findViewById(R.id.imageViewFilmResim);
            textViewFilmAd = itemView.findViewById(R.id.textViewFilmAd);
        }
    }
}
