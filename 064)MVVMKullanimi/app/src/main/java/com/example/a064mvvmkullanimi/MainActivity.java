package com.example.a064mvvmkullanimi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.a064mvvmkullanimi.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding  tasarim;
    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        tasarim = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        tasarim.setMainActivityNesnesi(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        viewModel.getSonuc().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tasarim.setHesaplamaSonucu(s);
            }
        });
    }

    public void buttonToplama(String alinansayi1, String alinansayi2){
        viewModel.toplamaYap(alinansayi1, alinansayi2);
    }

    public  void buttonCarpma(String alinansayi1, String alinansayi2){
        viewModel.carpmaYap(alinansayi1, alinansayi2);
    }
}