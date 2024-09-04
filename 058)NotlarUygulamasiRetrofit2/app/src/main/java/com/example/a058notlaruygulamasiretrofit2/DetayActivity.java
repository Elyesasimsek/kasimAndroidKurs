package com.example.a058notlaruygulamasiretrofit2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetayActivity extends AppCompatActivity {

    private Toolbar toolbarDetay;
    private EditText editTextDersDetay, editTextNot1Detay, editTextNot2Detay;
    private Notlar not;
    private NotlarDAOInterface notlarDIF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detay);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        toolbarDetay = findViewById(R.id.toolbarDetay);
        editTextDersDetay = findViewById(R.id.editTextDersDetay);
        editTextNot1Detay = findViewById(R.id.editTextNot1Detay);
        editTextNot2Detay = findViewById(R.id.editTextNot2Detay);
        not = (Notlar) getIntent().getSerializableExtra("nesne");
        toolbarDetay.setTitle("Not Detay");
        setSupportActionBar(toolbarDetay);

        notlarDIF = ApiUtils.getNotlarDaoInterface();

        editTextDersDetay.setText(not.getDersAdi());
        editTextNot1Detay.setText(not.getNot1());
        editTextNot2Detay.setText(not.getNot2());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.actionSil){
            Snackbar.make(toolbarDetay, "Silinsin mi?", Snackbar.LENGTH_SHORT).setAction("Evet", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    notlarDIF.notSil(Integer.parseInt(not.getNotId())).enqueue(new Callback<NotlarCevap>() {
                        @Override
                        public void onResponse(Call<NotlarCevap> call, Response<NotlarCevap> response) {

                        }

                        @Override
                        public void onFailure(Call<NotlarCevap> call, Throwable t) {

                        }
                    });

                    startActivity(new Intent(DetayActivity.this, MainActivity.class));
                    finish();
                }
            }).show();
            return true;
        } else if (id == R.id.actionDuzenle) {
            String dersAdi = editTextDersDetay.getText().toString().trim();
            String not1 = editTextNot1Detay.getText().toString().trim();
            String not2 = editTextNot2Detay.getText().toString().trim();
            if (TextUtils.isEmpty(dersAdi)){
                Snackbar.make(toolbarDetay, "Ders Adı Giriniz", Snackbar.LENGTH_SHORT).show();
                return false;
            }
            if (TextUtils.isEmpty(not1)){
                Snackbar.make(toolbarDetay, "Not 1 Giriniz", Snackbar.LENGTH_SHORT).show();
                return false;
            }
            if (TextUtils.isEmpty(not2)){
                Snackbar.make(toolbarDetay, "Not 2 Giriniz", Snackbar.LENGTH_SHORT).show();
                return false;
            }

            notlarDIF.notGuncelle(Integer.parseInt(not.getNotId()), dersAdi, Integer.parseInt(not1), Integer.parseInt(not2)).enqueue(new Callback<NotlarCevap>() {
                @Override
                public void onResponse(Call<NotlarCevap> call, Response<NotlarCevap> response) {

                }

                @Override
                public void onFailure(Call<NotlarCevap> call, Throwable t) {

                }
            });

            startActivity(new Intent(DetayActivity.this, MainActivity.class));
            finish();
            return true;
        }else {
            return false;
        }
    }
}