package com.example.a078oyuncalismasi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import com.example.a078oyuncalismasi.databinding.ActivityOyunEkraniBinding;

import java.util.Timer;
import java.util.TimerTask;

public class OyunEkraniActivity extends AppCompatActivity {

    private ActivityOyunEkraniBinding tasarim;


    private int anaKarakterX, anaKarakterY;
    private boolean dokunmaKontrol = false;
    private boolean baslangicKontrol = false;
    private int sariDaireX, sariDaireY;
    private int kirmiziUcgenX, kirmiziUcgenY;
    private int siyahKareX, siyahKareY;

    private Timer timer = new Timer();
    private Handler handler = new Handler();

    private int ekranGenisligi, ekranYuksekligi, anaKarakterGenisligi, anaKarakterYuksekligi;

    private int anaKarakterHiz, siyahKareHiz, sariDaireHiz, kirmiziUcgenHiz;

    private int skor = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tasarim =  DataBindingUtil.setContentView(this, R.layout.activity_oyun_ekrani);

        //cisimleri ekranın dışına çıkarma
        tasarim.imageViewSiyahKare.setX(-80);
        tasarim.imageViewSiyahKare.setY(-80);
        tasarim.imageViewKirmiziUcgen.setX(-80);
        tasarim.imageViewKirmiziUcgen.setY(-80);
        tasarim.imageViewSariDaire.setX(-80);
        tasarim.imageViewSariDaire.setY(-80);


        tasarim.main.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (baslangicKontrol){
                    if (event.getAction() == MotionEvent.ACTION_DOWN){
                        Log.e("MotionEvent", "Ekrana Dokunuldu");
                        dokunmaKontrol = true;
                    }
                    if (event.getAction() == MotionEvent.ACTION_UP){
                        Log.e("MotionEvent", "Ekranı Bıraktı");
                        dokunmaKontrol = false;
                    }
                }else {
                    baslangicKontrol = true;

                    tasarim.textViewOyunaBasla.setVisibility(View.INVISIBLE);

                    anaKarakterX = (int) tasarim.imageViewAnaKarakter.getX();
                    anaKarakterY = (int) tasarim.imageViewAnaKarakter.getY();

                    anaKarakterGenisligi = tasarim.imageViewAnaKarakter.getWidth();
                    anaKarakterYuksekligi = tasarim.imageViewAnaKarakter.getHeight();
                    ekranGenisligi = tasarim.main.getWidth();
                    ekranYuksekligi = tasarim.main.getHeight();

                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                   anaKarakterHareketEttirme();
                                   cisimleriHareketEttir();
                                   carpismaKontrol();
                                }
                            });
                        }
                    }, 0, 20);
                }



                return true;
            }
        });
    }

    public void anaKarakterHareketEttirme(){
        anaKarakterHiz = Math.round(ekranYuksekligi/60);

        if (dokunmaKontrol){
            anaKarakterY -= anaKarakterHiz;
        }else {
            anaKarakterY += anaKarakterHiz;
        }

        if (anaKarakterY <= 0){
            anaKarakterY = 0;
        }

        if (anaKarakterY >= ekranYuksekligi - anaKarakterYuksekligi){
            anaKarakterY = ekranYuksekligi - anaKarakterYuksekligi;
        }
        tasarim.imageViewAnaKarakter.setY(anaKarakterY);
    }

    public void cisimleriHareketEttir(){
        siyahKareHiz = Math.round(ekranGenisligi/40);

        siyahKareX -= siyahKareHiz;
        if (siyahKareX < 0){
            siyahKareX = ekranGenisligi + 20;
            siyahKareY = (int) Math.floor(Math.random() * ekranYuksekligi);
        }

        tasarim.imageViewSiyahKare.setX(siyahKareX);
        tasarim.imageViewSiyahKare.setY(siyahKareY);

        sariDaireHiz = Math.round(ekranGenisligi/60);

        sariDaireX -= sariDaireHiz;
        if (sariDaireX < 0){
            sariDaireX = ekranGenisligi + 20;
            sariDaireY = (int) Math.floor(Math.random() * ekranYuksekligi);
        }

        tasarim.imageViewSariDaire.setX(sariDaireX);
        tasarim.imageViewSariDaire.setY(sariDaireY);

        kirmiziUcgenHiz = Math.round(ekranGenisligi/20);

        kirmiziUcgenX -= kirmiziUcgenHiz;
        if (kirmiziUcgenX < 0){
            kirmiziUcgenX = ekranGenisligi + 20;
            kirmiziUcgenY = (int) Math.floor(Math.random() * ekranYuksekligi);
        }

        tasarim.imageViewKirmiziUcgen.setX(kirmiziUcgenX);
        tasarim.imageViewKirmiziUcgen.setY(kirmiziUcgenY);
    }

    public void carpismaKontrol(){
        float sariDaireMerkezX = sariDaireX + tasarim.imageViewSariDaire.getWidth()/3f;
        float sariDaireMerkezY = sariDaireY + tasarim.imageViewSariDaire.getHeight()/3f;

        if (0 <= sariDaireMerkezX && sariDaireMerkezX <= anaKarakterGenisligi && anaKarakterY <= sariDaireMerkezY && sariDaireMerkezY <= anaKarakterY + anaKarakterYuksekligi){
            skor += 20;
            sariDaireX = -10;
        }

        float kirmiziUcgenMerkezX = kirmiziUcgenX + tasarim.imageViewKirmiziUcgen.getWidth()/3f;
        float kirmiziUcgenMerkezY = kirmiziUcgenY + tasarim.imageViewKirmiziUcgen.getHeight()/3f;

        if (0 <= kirmiziUcgenMerkezX && kirmiziUcgenMerkezX <= anaKarakterGenisligi && anaKarakterY <= kirmiziUcgenMerkezY && kirmiziUcgenMerkezY <= anaKarakterY + anaKarakterYuksekligi){
            skor += 50;
            kirmiziUcgenX = -10;
        }

        int siyahKareMerkezX = siyahKareX + tasarim.imageViewSiyahKare.getWidth()/10;
        int siyahKareMerkezY = siyahKareY + tasarim.imageViewSiyahKare.getHeight()/10;

        if (0 <= siyahKareMerkezX && siyahKareMerkezX <= anaKarakterGenisligi && anaKarakterY <= siyahKareMerkezY && siyahKareMerkezY <= anaKarakterY + anaKarakterYuksekligi){
            siyahKareX = -10;

            timer.cancel();
            timer = null;

            Intent intent = new Intent(OyunEkraniActivity.this, SonucEkraniActivity.class);
            intent.putExtra("skor", skor);
            startActivity(intent);
        }
        tasarim.textViewSkor.setText(String.valueOf(skor));
    }
}