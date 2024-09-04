package com.example.recyclerviewkullanimi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BasitRVAdapter extends RecyclerView.Adapter<BasitRVAdapter.CardViewTasarimNesneleriniTutucu> {
    private Context context;
    private List<String> ulkelerDisaridanGelenList;

    public BasitRVAdapter(Context context, List<String> ulkelerDisaridanGelenList) {
        this.context = context;
        this.ulkelerDisaridanGelenList = ulkelerDisaridanGelenList;
    }

    public class CardViewTasarimNesneleriniTutucu extends RecyclerView.ViewHolder{
        public TextView textViewSatirYazi;
        public CardView cardViewSatir;
        public ImageView imageViewResim;

        public CardViewTasarimNesneleriniTutucu(View view){
            super(view);
            textViewSatirYazi = view.findViewById(R.id.textViewSatirYazi);
            cardViewSatir = view.findViewById(R.id.cardViewSatir);
            imageViewResim = view.findViewById(R.id.imageViewResim);
        }
    }

    @NonNull
    @Override
    public CardViewTasarimNesneleriniTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_tasarim, parent, false);
        return new CardViewTasarimNesneleriniTutucu(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewTasarimNesneleriniTutucu holder, int position) {
        String ulke = ulkelerDisaridanGelenList.get(position);
        holder.textViewSatirYazi.setText(ulke);
        holder.cardViewSatir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Seçtiğiniz Ülke: " + ulke, Toast.LENGTH_SHORT).show();
            }
        });

        holder.imageViewResim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(context, holder.imageViewResim);
                popupMenu.getMenuInflater().inflate(R.menu.card_menu, popupMenu.getMenu());
                popupMenu.show();

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();
                        if (id == R.id.actionSil){
                            Toast.makeText(context, "Sil Tıklandı: "+ ulke, Toast.LENGTH_SHORT).show();
                            return true;
                        } else if (id == R.id.actionDuzenle) {
                            Toast.makeText(context, "Düzenle Tıklandı: " + ulke, Toast.LENGTH_SHORT).show();
                            return true;
                        }else {
                            return false;
                        }
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return ulkelerDisaridanGelenList.size();
    }
}