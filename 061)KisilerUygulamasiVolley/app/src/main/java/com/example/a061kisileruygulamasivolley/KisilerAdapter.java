package com.example.a061kisileruygulamasivolley;

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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KisilerAdapter extends RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu>{
    private Context mContext;
    private List<Kisiler> kisilerList;

    public KisilerAdapter(Context mContext, List<Kisiler> kisilerList) {
        this.mContext = mContext;
        this.kisilerList = kisilerList;

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

                                    String url = "https://elyesasimsek.com/kisiler/delete_kisiler.php";
                                    StringRequest postStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                                        @Override
                                        public void onResponse(String response) {
                                            tumKisiler();

                                        }
                                    }, new Response.ErrorListener() {
                                        @Override
                                        public void onErrorResponse(VolleyError error) {

                                        }
                                    }){
                                        @Nullable
                                        @Override
                                        protected Map<String, String> getParams() throws AuthFailureError {
                                            Map<String, String> params = new HashMap<>();
                                            params.put("kisiId", String.valueOf(kisi.getKisiId()));
                                            return params;
                                        }
                                    };
                                    Volley.newRequestQueue(mContext).add(postStringRequest);
                                }
                            }).show();
                            return true;
                        } else if (id == R.id.actionGuncelle) {
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

                String url = "https://elyesasimsek.com/kisiler/update_kisiler.php";
                StringRequest postStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        tumKisiler();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("kisiId", String.valueOf(kisi.getKisiId()));
                        params.put("kisiAd", kisiAd);
                        params.put("kisiTel", kisiTel);
                        return params;
                    }
                };
                Volley.newRequestQueue(mContext).add(postStringRequest);
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
        String url = "https://elyesasimsek.com/kisiler/tum_kisiler.php";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                kisilerList = new ArrayList<>();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray kisiler = jsonObject.getJSONArray("kisiler");
                    for (int i = 0;i < kisiler.length();i++){
                        JSONObject k = kisiler.getJSONObject(i);
                        int kisiId = k.getInt("kisiId");
                        String kisiAd = k.getString("kisiAd");
                        String kisiTel = k.getString("kisiTel");
                        Kisiler kisi = new Kisiler(kisiId, kisiAd, kisiTel);
                        kisilerList.add(kisi);
                    }
                    notifyDataSetChanged();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley.newRequestQueue(mContext).add(stringRequest);
    }
}
