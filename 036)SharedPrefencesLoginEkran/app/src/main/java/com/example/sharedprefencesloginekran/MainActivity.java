package com.example.sharedprefencesloginekran;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUsername, editTextPassword;
    private Button buttonGirisYap;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonGirisYap = findViewById(R.id.buttonGirisYap);

        sharedPreferences = getSharedPreferences("GirisBilgi", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        username = sharedPreferences.getString("username", "Kullanıcı adı yok");
        password = sharedPreferences.getString("password", "Şifre yok");

        if (username.equals("admin") && password.equals("123")){
            startActivity(new Intent(MainActivity.this, AnaEkranActivity.class));
            finish();
        }

        buttonGirisYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextUsername.getText().toString().equals("admin") && editTextPassword.getText().toString().equals("123")){
                    editor.putString("username", editTextUsername.getText().toString());
                    editor.putString("password", editTextPassword.getText().toString());
                    editor.commit();

                    startActivity(new Intent(MainActivity.this, AnaEkranActivity.class));
                    finish();
                }else{
                    Toast.makeText(MainActivity.this, "Giriş Hatalı", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}