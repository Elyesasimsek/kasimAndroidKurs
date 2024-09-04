package com.example.a075kopyalayapistir;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import com.example.a075kopyalayapistir.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    private ActivitySecondBinding tasarim;

    private ClipboardManager kopyalamaPanom;
    private ClipData clipData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        tasarim = DataBindingUtil.setContentView(this, R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        kopyalamaPanom = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        tasarim.buttonYapistir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clipData = kopyalamaPanom.getPrimaryClip();
                ClipData.Item item = clipData.getItemAt(0);
                String kopyalanmisYazi = item.getText().toString();
                tasarim.textView.setText(kopyalanmisYazi);
                Toast.makeText(getApplicationContext(), "Yazı Yapıştırıldı", Toast.LENGTH_SHORT).show();
            }
        });
    }
}