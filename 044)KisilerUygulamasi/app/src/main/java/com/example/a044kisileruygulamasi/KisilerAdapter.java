package com.example.a044kisileruygulamasi;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class KisilerAdapter extends RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu>{
    private Context mContext;
    private List<Kisiler> kisilerList;
    private Veritabani vt;

    public KisilerAdapter(Context mContext, List<Kisiler> kisilerList, Veritabani vt) {
        this.mContext = mContext;
        this.kisilerList = kisilerList;
        this.vt = vt;
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kisi_card_tasarim, parent, false);
        return new CardTasarimTutucu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        Kisiler kisi = kisilerList.get(position);

        holder.textViewKisiBilgi.setText(kisi.getKisiAd() + " - " + kisi.getKisiTel());
        holder.imageViewNokta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(mContext, holder.imageViewNokta);
                popupMenu.getMenuInflater().inflate(R.menu.pop_up_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();
                        if (id == R.id.actionSil){
                            Snackbar.make(holder.imageViewNokta, "Kişi Silinsin mi?", Snackbar.LENGTH_SHORT).setAction("Evet", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    new KisilerDAO().KisiSil(vt, kisi.getKisiId());
                                    kisilerList = new KisilerDAO().tumKisiler(vt);
                                    notifyDataSetChanged();
                                }
                            }) .show();
                            return true;
                        }else if (id == R.id.actionGuncele){
                            alertGoster(kisi);
                            return true;
                        }else {
                            return false;
                        }
                    }
                });
                popupMenu.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return kisilerList.size();
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private TextView textViewKisiBilgi;
        private ImageView imageViewNokta;

        public CardTasarimTutucu(@NonNull View itemView) {
            super(itemView);
            textViewKisiBilgi = itemView.findViewById(R.id.textViewKisiBilgi);
            imageViewNokta = itemView.findViewById(R.id.imageViewNokta);

        }
    }

    public void alertGoster(Kisiler kisi){
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View tasarim = layoutInflater.inflate(R.layout.alert_tasarim, null);
        EditText editTextAd, editTextTel;
        editTextAd = tasarim.findViewById(R.id.editTextAd);
        editTextTel = tasarim.findViewById(R.id.editTextTel);

        editTextAd.setText(kisi.getKisiAd());
        editTextTel.setText(kisi.getKisiTel());

        AlertDialog.Builder ad = new AlertDialog.Builder(mContext);
        ad.setTitle("Kişi Güncelle");
        ad.setView(tasarim);
        ad.setPositiveButton("Güncelle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String kisiAd = editTextAd.getText().toString().trim();
                String kisiTel = editTextTel.getText().toString().trim();

                new KisilerDAO().KisiGuncelle(vt, kisi.getKisiId(), kisiAd, kisiTel);
                kisilerList = new KisilerDAO().tumKisiler(vt);
                notifyDataSetChanged();
            }
        });
        ad.setNegativeButton("İptal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        ad.create().show();
    }
}
