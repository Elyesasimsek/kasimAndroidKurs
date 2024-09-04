package com.example.a012radiobuttoncheckboxkullanmi;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBoxJava, checkBoxKotlin;
    private RadioButton radioButtonBarcelona, radioButtonRealMadrid;
    private Button button;

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

        checkBoxJava = findViewById(R.id.checkBoxJava);
        checkBoxKotlin = findViewById(R.id.checkBoxKotlin);
        radioButtonBarcelona = findViewById(R.id.radioButtonBarcelona);
        radioButtonRealMadrid = findViewById(R.id.radioButtonRealMadrid);
        button = findViewById(R.id.button);

        radioButtonBarcelona.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(MainActivity.this, "Tebrikler" ,Toast.LENGTH_SHORT).show();
                }
            }
        });

        checkBoxJava.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(MainActivity.this, "Tebrikler JAVA'yı Seçtiniz.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean javaDurum = checkBoxJava.isChecked();
                Boolean kotlinDurum = checkBoxKotlin.isChecked();
                Boolean barcelonaDurum = radioButtonBarcelona.isChecked();
                Boolean realMadridDurum = radioButtonRealMadrid.isChecked();
                Log.e("Java Durum: ", String.valueOf(javaDurum));
                Log.e("Kotlin Durum: ", String.valueOf(kotlinDurum));
                Log.e("Barcelona Durum: ", String.valueOf(barcelonaDurum));
                Log.e("Real Madrid Durum: ", String.valueOf(realMadridDurum));
            }
        });
    }
}