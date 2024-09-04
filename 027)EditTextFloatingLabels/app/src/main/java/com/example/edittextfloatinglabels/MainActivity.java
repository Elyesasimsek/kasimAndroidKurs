package com.example.edittextfloatinglabels;

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

    private EditText editTextAd, editTextTel;
    private Button buttonYap;

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

        editTextAd = findViewById(R.id.editTextAd);
        editTextTel = findViewById(R.id.editTextTel);
        buttonYap = findViewById(R.id.buttonYap);

        buttonYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ad = editTextAd.getText().toString();
                String tel = editTextTel.getText().toString();

                Toast.makeText(getApplicationContext(), ad + " - " + tel, Toast.LENGTH_SHORT).show();
            }
        });
    }
}