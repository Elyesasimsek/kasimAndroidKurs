package com.example.a047fbpushnotification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MesajServis extends FirebaseMessagingService {

    private NotificationCompat.Builder builder;

    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {
        super.onMessageReceived(message);

        Log.e("Başlık", message.getNotification().getTitle());
        Log.e("İçerik", message.getNotification().getBody());
        DurumaBagli(message.getNotification().getTitle(), message.getNotification().getBody());
    }

    public void DurumaBagli(String baslik, String icerik){
        NotificationManager bildirimYoneticisi = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        Intent intent = new Intent(this, MainActivity.class);
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
            builder.setContentTitle(baslik);
            builder.setContentText(icerik);
            builder.setSmallIcon(R.drawable.baseline_beach_access_24);
            builder.setAutoCancel(true);
            builder.setContentIntent(gidilecekIntent);
        }else {
            builder = new NotificationCompat.Builder(this);
            builder.setContentTitle(baslik);
            builder.setContentText(icerik);
            builder.setSmallIcon(R.drawable.baseline_beach_access_24);
            builder.setAutoCancel(true);
            builder.setContentIntent(gidilecekIntent);
            builder.setPriority(Notification.PRIORITY_HIGH);
        }
        bildirimYoneticisi.notify(1, builder.build());
    }
}
