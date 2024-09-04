package com.example.a058notlaruygulamasiretrofit2;

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

public class NotlarAdapter extends RecyclerView.Adapter<NotlarAdapter.CardTasarimTutucu>{
    private Context mContext;
    private List<Notlar> notlarList;

    public NotlarAdapter(Context mContext, List<Notlar> notlarList) {
        this.mContext = mContext;
        this.notlarList = notlarList;
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_tasarim, parent, false);
        return new CardTasarimTutucu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        Notlar not =notlarList.get(position);
        holder.textViewDersAdi.setText(not.getDersAdi());
        holder.textViewNot1.setText(String.valueOf(not.getNot1()));
        holder.textViewNot2.setText(String.valueOf(not.getNot2()));
        holder.notCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetayActivity.class);
                intent.putExtra("nesne", not);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (notlarList == null) {
            return 0;
        } else {
            return notlarList.size();
        }
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private TextView textViewDersAdi, textViewNot1, textViewNot2;
        private CardView notCard;

        public CardTasarimTutucu(@NonNull View itemView) {
            super(itemView);
            textViewDersAdi = itemView.findViewById(R.id.textViewDersAdi);
            textViewNot1 = itemView.findViewById(R.id.textViewNot1);
            textViewNot2 = itemView.findViewById(R.id.textViewNot2);
            notCard = itemView.findViewById(R.id.notCard);
        }
    }
}
