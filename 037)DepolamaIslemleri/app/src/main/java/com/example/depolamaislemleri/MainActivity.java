package com.example.depolamaislemleri;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText editTextGirdi;
    private Button buttonYaz, buttonOku, buttonSil;

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

        editTextGirdi = findViewById(R.id.editTextGirdi);
        buttonYaz = findViewById(R.id.buttonYaz);
        buttonOku = findViewById(R.id.buttonOku);
        buttonSil = findViewById(R.id.buttonSil);

        buttonYaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dahiliYaz();
                //hariciYaz();
            }
        });

        buttonOku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dahiliOku();
                //hariciOku();
            }
        });

        buttonSil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dahiliSil();
                //hariciSil();
            }
        });
    }

    public void hariciYaz(){
        try {
            File dosyaYolu = Environment.getExternalStorageDirectory();
            File dosya = new File(dosyaYolu, "dosyam.txt");
            if (!dosya.exists()) {
                dosya.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(dosya);
            BufferedWriter yazici = new BufferedWriter(fileWriter);

            yazici.write(editTextGirdi.getText().toString());
            yazici.flush();
            yazici.close();
            fileWriter.close();

            editTextGirdi.setText("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void hariciOku(){
        try {
            File dosyaYolu = Environment.getExternalStorageDirectory();
            File dosya = new File(dosyaYolu, "dosyam.txt");

            FileReader fileReader = new FileReader(dosya);
            BufferedReader okuyucu = new BufferedReader(fileReader);

            StringBuilder stringBuilder = new StringBuilder();
            String satir = "";
            while ((satir = okuyucu.readLine()) != null){
                stringBuilder.append(satir + "\n");
            }
            okuyucu.close();

            editTextGirdi.setText(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void hariciSil(){
        File dosyaYolu = Environment.getExternalStorageDirectory();
        File dosya = new File(dosyaYolu, "dosyam.txt");

        dosya.delete();
        editTextGirdi.setText("");
    }

    public void  dahiliYaz(){
        try {
            FileOutputStream fileOutputStream = openFileOutput("dosyam.txt", MODE_PRIVATE);
            OutputStreamWriter yazici = new OutputStreamWriter(fileOutputStream);
            yazici.write(editTextGirdi.getText().toString());
            yazici.close();
            editTextGirdi.setText("");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void dahiliOku(){
        try {
            FileInputStream fileInputStream = openFileInput("dosyam.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader okuyucu = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();
            String satir = "";
            while ((satir = okuyucu.readLine()) != null){
                stringBuilder.append(satir + "\n");
            }
            okuyucu.close();

            editTextGirdi.setText(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dahiliSil(){
        File yol = getFilesDir();
        File file = new File(yol, "dosyam.txt");
        editTextGirdi.setText(String.valueOf( file.delete()));
    }
}

































