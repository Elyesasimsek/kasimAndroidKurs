package com.example.a062kisileruygulamasiretrofit2;

import android.app.AlertDialog;
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
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KisilerAdapter extends RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu>{
    private Context mContext;
    private List<Kisiler> kisilerList;
    private KisilerDAOInterface kisilerDIF;

    public KisilerAdapter(Context mContext, List<Kisiler> kisilerList, KisilerDAOInterface kisilerDIF) {
        this.mContext = mContext;
        this.kisilerList = kisilerList;
        this.kisilerDIF = kisilerDIF;
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
        holder.imageViewMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(mContext, holder.imageViewMenu);
                popupMenu.getMenuInflater().inflate(R.menu.pop_up_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();
                        if (id == R.id.actionSil){
                            Snackbar.make(holder.imageViewMenu, "Kişi Silinsin mi?", Snackbar.LENGTH_SHORT).setAction("Evet", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    kisilerDIF = ApiUtils.getKisilerDaoInterface();
                                    kisilerDIF.kisiSil(Integer.parseInt(kisi.getKisiId())).enqueue(new Callback<KisilerCevap>() {
                                        @Override
                                        public void onResponse(Call<KisilerCevap> call, Response<KisilerCevap> response) {
                                            Toast.makeText(mContext, kisi.getKisiAd() + " Kişi silindi", Toast.LENGTH_SHORT).show();
                                            tumKisiler();
                                        }

                                        @Override
                                        public void onFailure(Call<KisilerCevap> call, Throwable t) {

                                        }
                                    });
                                }
                            }).show();
                            return true;
                        } else if (id == R.id.actionDuzenle) {
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
        if (kisilerList == null) {
            return 0;
        } else {
            return kisilerList.size();
        }
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private TextView textViewKisiBilgi;
        private ImageView imageViewMenu;

        public CardTasarimTutucu(@NonNull View itemView) {
            super(itemView);
            textViewKisiBilgi = itemView.findViewById(R.id.textViewKisiBilgi);
            imageViewMenu = itemView.findViewById(R.id.imageViewMenu);
        }
    }

    public void alertGoster(Kisiler kisi) {
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

                kisilerDIF.kisiGuncelle(Integer.parseInt(kisi.getKisiId()), kisiAd, kisiTel).enqueue(new Callback<KisilerCevap>() {
                    @Override
                    public void onResponse(Call<KisilerCevap> call, Response<KisilerCevap> response) {
                        Toast.makeText(mContext, kisiAd + " Kişi güncellendi", Toast.LENGTH_SHORT).show();
                        tumKisiler();
                    }

                    @Override
                    public void onFailure(Call<KisilerCevap> call, Throwable t) {

                    }
                });
            }
        });
        ad.setNegativeButton("İptal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        ad.create().show();
    }

    public void tumKisiler(){
        kisilerDIF.tumKisiler().enqueue(new Callback<KisilerCevap>() {
            @Override
            public void onResponse(Call<KisilerCevap> call, Response<KisilerCevap> response) {
                kisilerList = response.body().getKisiler();
                notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<KisilerCevap> call, Throwable t) {

            }
        });
    }
}
