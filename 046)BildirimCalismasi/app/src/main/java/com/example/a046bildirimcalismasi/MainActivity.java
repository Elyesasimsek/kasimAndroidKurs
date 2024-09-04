package com.example.a046bildirimcalismasi;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button buttonBildirim;
    private NotificationCompat.Builder builder;

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

        buttonBildirim = findViewById(R.id.buttonBildirim);
        buttonBildirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DurumaBagli();
            }
        });
    }

    public void DurumaBagli(){
        NotificationManager bildirimYoneticisi = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        Intent intent = new Intent(MainActivity.this, KarsilamaEkraniActivity.class);
        PendingIntent gidilecekIntent = PendingIntent.getActivity(this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            String kanalId = "kanalId";
            String kanalAd = "kanalAd";
            String kanalTanim = "kanalTanim";
            int kanalOnceligi = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel kanal = bildirimYoneticisi.getNotificationChannel(kanalId);
            if (kanal == null){
                kanal = new NotificationChannel(kanalId, kanalAd, kanalOnceligi);
                kanal.setDescription(kanalTanim);
                bildirimYoneticisi.createNotificationChannel(kanal);
            }

            builder = new NotificationCompat.Builder(this, kanalId);
            builder.setContentTitle("Başlık");
            builder.setContentText("İçerik");
            builder.setSmallIcon(R.drawable.resim);
            builder.setAutoCancel(true);
            builder.setContentIntent(gidilecekIntent);
        }else {
            builder = new NotificationCompat.Builder(this);
            builder.setContentTitle("Başlık");
            builder.setContentText("İçerik");
            builder.setSmallIcon(R.drawable.resim);
            builder.setAutoCancel(true);
            builder.setContentIntent(gidilecekIntent);
            builder.setPriority(Notification.PRIORITY_HIGH);
        }
        bildirimYoneticisi.notify(1, builder.build());
    }
}