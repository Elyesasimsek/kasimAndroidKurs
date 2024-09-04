package com.example.a071animasyonuygulamasi;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;
    private Button button;
    private Animation downToUp, upToDown, leftToRight, rightToLeft, upDownInfinite;

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

        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        downToUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.down_to_up);//aşağıdan yukarı
        //button.setAnimation(downToUp);

        upToDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.up_to_down);//yukardan aşağı
        //textView.setAnimation(upToDown);
        //imageView.setAnimation(upToDown);

        leftToRight = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left_to_right);//soldan sağa
        textView.setAnimation(leftToRight);
        //imageView.setAnimation(leftToRight);

        rightToLeft = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_to_left);//sağdan sola
        button.setAnimation(rightToLeft);

        upDownInfinite = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.up_down_infinite);//yukarı aşağı sonsuza kadar devam
        imageView.setAnimation(upDownInfinite);


    }
}