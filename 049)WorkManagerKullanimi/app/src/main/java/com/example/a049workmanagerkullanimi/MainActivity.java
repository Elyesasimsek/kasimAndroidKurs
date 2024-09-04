package com.example.a049workmanagerkullanimi;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import com.example.a049workmanagerkullanimi.databinding.ActivityMainBinding;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding tasarim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        tasarim = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(tasarim.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tasarim.buttonYap.setOnClickListener(new View.OnClickListener() {
            //Constraints calismaKosulu = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
            @Override
            public void onClick(View v) {
                //WorkRequest istek = new OneTimeWorkRequest.Builder(MyWorker.class).setInitialDelay(10, TimeUnit.SECONDS).setConstraints(calismaKosulu).build();

                //WorkManager.getInstance(MainActivity.this).enqueue(istek);*/

            WorkRequest istek = new PeriodicWorkRequest.Builder(MyWorkerBildirim.class, 15, TimeUnit.MINUTES).setInitialDelay(10, TimeUnit.SECONDS).build();
            WorkManager.getInstance(MainActivity.this).enqueue(istek);

                WorkManager.getInstance(MainActivity.this).getWorkInfoByIdLiveData(istek.getId()).observe(MainActivity.this, workInfo -> {
                    String durum = workInfo.getState().name();
                    Log.e("Arkaplan İşlem Durumu", durum);
                });
            }
        });
    }
}