package com.example.a017datatimerpickerkullanimi;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText editTextSaat, editTextTarih;

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

        editTextSaat = findViewById(R.id.editTextSaat);
        editTextTarih = findViewById(R.id.editTextTarih);

        editTextSaat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int saat = calendar.get(Calendar.HOUR_OF_DAY);
                int dakika = calendar.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog;
                timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        editTextSaat.setText(hourOfDay + " : " + minute);
                    }
                }, saat, dakika, true);
                timePickerDialog.setTitle("Saat Seçiniz");
                timePickerDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Ayarla", timePickerDialog);
                timePickerDialog.setButton(DialogInterface.BUTTON_NEGATIVE,"İptal", timePickerDialog);

                timePickerDialog.show();
            }
        });

        editTextTarih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int yil = calendar.get(Calendar.YEAR);
                int ay = calendar.get(Calendar.MONTH);
                int gun = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog;
                datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        editTextTarih.setText(month +  "/" + dayOfMonth + "/" + year);
                    }
                }, yil, ay, gun);
                datePickerDialog.setTitle("Tarih Seçiniz");
                datePickerDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Ayarla", datePickerDialog);
                datePickerDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "İptal", datePickerDialog);

                datePickerDialog.show();
            }
        });
    }
}