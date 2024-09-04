package com.example.a054sozlukuygulamasi;

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

public class KelimelerAdapter extends RecyclerView.Adapter<KelimelerAdapter.CardTasarimTutucu>{
    private Context mContext;
    private List<Kelimeler> kelimelerList;

    public KelimelerAdapter(Context mContext, List<Kelimeler> kelimelerList) {
        this.mContext = mContext;
        this.kelimelerList = kelimelerList;
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_tasarim, parent, false);
        return new CardTasarimTutucu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        Kelimeler kelime =kelimelerList.get(position);
        holder.textViewIngilizce.setText(kelime.getIngilizce());
        holder.textViewTurkce.setText(kelime.getTurkce());
        holder.kelimeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetayActivity.class);
                intent.putExtra("nesne", kelime);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return kelimelerList.size();
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private TextView textViewIngilizce, textViewTurkce;
        private CardView kelimeCard;

        public CardTasarimTutucu(@NonNull View itemView) {
            super(itemView);
            textViewIngilizce = itemView.findViewById(R.id.textViewIngilizce);
            textViewTurkce = itemView.findViewById(R.id.textViewTurkce);
            kelimeCard = itemView.findViewById(R.id.kelimeCard);
        }
    }
}
