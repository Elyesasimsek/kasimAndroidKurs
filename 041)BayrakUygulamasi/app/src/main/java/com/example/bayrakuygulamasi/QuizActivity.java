package com.example.bayrakuygulamasi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashSet;

public class QuizActivity extends AppCompatActivity {

    private TextView textViewDogru, textViewYanlis, textViewSoruSayi;
    private ImageView imageViewBayrak;
    private Button buttonA, buttonB, buttonC, buttonD;
    private ArrayList<Bayraklar> sorularListe;
    private ArrayList<Bayraklar> yanlisSeceneklerListe;
    private Bayraklar dogruSoru;
    private Veritabani vt;

    private int soruSayac = 0;
    private int yanlisSayac = 0;
    private int dogruSayac = 0;

    private HashSet<Bayraklar> seceneklerKaristirmaListe = new HashSet<>();
    private ArrayList<Bayraklar> seceneklerListe = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textViewDogru = findViewById(R.id.textViewDogru);
        textViewYanlis = findViewById(R.id.textViewYanlis);
        textViewSoruSayi = findViewById(R.id.textViewSoruSayi);
        imageViewBayrak = findViewById(R.id.imageViewBayrak);
        buttonA = findViewById(R.id.buttonA);
        buttonB = findViewById(R.id.buttonB);
        buttonC = findViewById(R.id.buttonC);
        buttonD = findViewById(R.id.buttonD);

        vt = new Veritabani(this);
        sorularListe = new BayraklarDAO().rastgeleGetir(vt);
        soruYukle();

        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dogruKontrol(buttonA);
                sayacKontrol();
            }
        });

        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dogruKontrol(buttonB);
                sayacKontrol();
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dogruKontrol(buttonC);
                sayacKontrol();
            }
        });

        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dogruKontrol(buttonD);
                sayacKontrol();
            }
        });
    }

    public void soruYukle(){
        textViewSoruSayi.setText((soruSayac+1)+ ". Soru");

        dogruSoru = sorularListe.get(soruSayac);

        yanlisSeceneklerListe = new BayraklarDAO().rastgele3YanlisGetir(vt, dogruSoru.getBayrakId());
        imageViewBayrak.setImageResource(getResources().getIdentifier(dogruSoru.getBayrakResim(), "drawable", getPackageName()));

        seceneklerKaristirmaListe.clear();;
        seceneklerKaristirmaListe.add(dogruSoru);
        seceneklerKaristirmaListe.add(yanlisSeceneklerListe.get(0));
        seceneklerKaristirmaListe.add(yanlisSeceneklerListe.get(1));
        seceneklerKaristirmaListe.add(yanlisSeceneklerListe.get(2));
        seceneklerListe.clear();

        for (Bayraklar b:seceneklerKaristirmaListe){
            seceneklerListe.add(b);
        }
        buttonA.setText(seceneklerListe.get(0).getBayrakAd());
        buttonB.setText(seceneklerListe.get(1).getBayrakAd());
        buttonC.setText(seceneklerListe.get(2).getBayrakAd());
        buttonD.setText(seceneklerListe.get(3).getBayrakAd());
    }

    public void dogruKontrol(Button button){
        String buttonYazi = button.getText().toString();
        String dogruCevap = dogruSoru.getBayrakAd();

        if (buttonYazi.equals(dogruCevap)){
            dogruSayac++;
        }else {
            yanlisSayac++;
        }
        textViewDogru.setText("Doğru: " + dogruSayac);
        textViewYanlis.setText("Yanlış: " +yanlisSayac);
    }

    public void sayacKontrol(){
        soruSayac++;
        if (soruSayac != 7){
            soruYukle();
        }else{
            Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
            intent.putExtra("dogrusayac", dogruSayac);
            startActivity(intent);
            finish();
        }
    }
}