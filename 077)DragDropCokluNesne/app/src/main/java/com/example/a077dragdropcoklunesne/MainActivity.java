package com.example.a077dragdropcoklunesne;

import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import com.example.a077dragdropcoklunesne.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnDragListener, View.OnLongClickListener {

    private ActivityMainBinding tasarim;
    private  static final String YAZI_ETIKET = "YAZI";
    private  static final String BUTTON_ETIKET = "BUTTON";
    private  static final String RESIM_ETIKET = "RESİM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        tasarim = DataBindingUtil.setContentView(this, R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tasarim.textView.setTag(YAZI_ETIKET);
        tasarim.button.setTag(BUTTON_ETIKET);
        tasarim.imageView.setTag(RESIM_ETIKET);

        tasarim.textView.setOnLongClickListener(this);
        tasarim.button.setOnLongClickListener(this);
        tasarim.imageView.setOnLongClickListener(this);

        tasarim.ustTasarim.setOnDragListener(this);
        tasarim.solTasarim.setOnDragListener(this);
        tasarim.sagTasarim.setOnDragListener(this);


    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        switch (event.getAction()){
            case DragEvent.ACTION_DRAG_STARTED:
            case DragEvent.ACTION_DRAG_LOCATION:
                return true;
            case DragEvent.ACTION_DRAG_ENTERED:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
                    BlendModeColorFilter colorFilter = new BlendModeColorFilter(Color.YELLOW, BlendMode.SRC_IN);
                    v.getBackground().setColorFilter(colorFilter);
                    v.invalidate();
                } else {
                    PorterDuffColorFilter colorFilter = new PorterDuffColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_IN);
                    v.getBackground().setColorFilter(colorFilter);
                    v.invalidate();
                }
                return true;
            case DragEvent.ACTION_DRAG_EXITED:
            case DragEvent.ACTION_DRAG_ENDED:
                v.getBackground().clearColorFilter();
                v.invalidate();
                return true;
            case DragEvent.ACTION_DROP:
                v.getBackground().clearColorFilter();
                v.invalidate();
                View gorselNesne = (View) event.getLocalState();
                ViewGroup eskiTasarim = (ViewGroup) gorselNesne.getParent();
                eskiTasarim.removeView(gorselNesne);

                LinearLayout hedefTasarim = (LinearLayout) v;
                hedefTasarim.addView(gorselNesne);
                gorselNesne.setVisibility(View.VISIBLE);
                return true;
            default:break;
        }

        return false;
    }

    @Override
    public boolean onLongClick(View v) {
        ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
        String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

        ClipData clipData = new ClipData(v.getTag().toString(), mimeTypes, item);

        View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
        v.startDragAndDrop(clipData, shadowBuilder, v, 0);
        v.setVisibility(View.INVISIBLE);
        return true;
    }
}