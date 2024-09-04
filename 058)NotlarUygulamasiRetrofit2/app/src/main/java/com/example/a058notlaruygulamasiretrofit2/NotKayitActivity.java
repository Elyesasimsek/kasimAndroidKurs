package com.example.a058notlaruygulamasiretrofit2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotKayitActivity extends AppCompatActivity {

    private Toolbar toolbarNotKayit;
    private EditText editTextDers, editTextNot1, editTextNot2;
    private Button buttonKaydet;
    private NotlarDAOInterface notlarDIF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_not_kayit);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        toolbarNotKayit = findViewById(R.id.toolbarNotKayit);
        editTextDers = findViewById(R.id.editTextDers);
        editTextNot1 = findViewById(R.id.editTextNot1);
        editTextNot2 = findViewById(R.id.editTextNot2);
        buttonKaydet = findViewById(R.id.buttonKaydet);
        toolbarNotKayit.setTitle("Not Kayıt");
        setSupportActionBar(toolbarNotKayit);

        notlarDIF = ApiUtils.getNotlarDaoInterface();

        buttonKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dersAdi = editTextDers.getText().toString().trim();
                String not1 = editTextNot1.getText().toString().trim();
                String not2 = editTextNot2.getText().toString().trim();

                if (TextUtils.isEmpty(dersAdi)){
                    Snackbar.make(toolbarNotKayit, "Ders adı giriniz", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(not1)){
                    Snackbar.make(toolbarNotKayit, "Not 1 giriniz", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(not2)) {
                    Snackbar.make(toolbarNotKayit, "Not 2 giriniz", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                notlarDIF.notEkle(dersAdi, Integer.parseInt(not1), Integer.parseInt(not2)).enqueue(new Callback<NotlarCevap>() {
                    @Override
                    public void onResponse(Call<NotlarCevap> call, Response<NotlarCevap> response) {

                    }

                    @Override
                    public void onFailure(Call<NotlarCevap> call, Throwable t) {

                    }
                });

                startActivity(new Intent(NotKayitActivity.this, MainActivity.class));
                finish();
            }
        });

    }
}