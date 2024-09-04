package com.example.sharedprefencesloginekran;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AnaEkranActivity extends AppCompatActivity {

    private Button buttonCikisYap;
    private TextView textViewCikti;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ana_ekran);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        buttonCikisYap = findViewById(R.id.buttonCikisYap);
        textViewCikti = findViewById(R.id.textViewCikti);

        sharedPreferences = getSharedPreferences("GirisBilgi", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        username = sharedPreferences.getString("username", "Kullanıcı adı yok");
        password = sharedPreferences.getString("password", "Şifre yok");

        textViewCikti.setText("Username: " + username + " Password: " + password);

        buttonCikisYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.remove("username");
                editor.remove("password");
                editor.commit();

                startActivity(new Intent(AnaEkranActivity.this, MainActivity.class));
            }
        });
    }
}