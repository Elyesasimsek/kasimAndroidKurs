package com.example.a076dragdropteknesne;

import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import com.example.a076dragdropteknesne.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding tasarim;
    private static final String BUTTON_ETIKET = "DRAG BUTTON";
    private RelativeLayout.LayoutParams layoutParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        tasarim = DataBindingUtil.setContentView(this, R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rl), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tasarim.button.setTag(BUTTON_ETIKET);
        tasarim.button.setOnLongClickListener(new View.OnLongClickListener() {
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
        });
        tasarim.rl.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                switch (event.getAction()){
                    case  DragEvent.ACTION_DRAG_STARTED:
                        layoutParams = (RelativeLayout.LayoutParams) tasarim.button.getLayoutParams();
                        Log.e("Sonuç", "ACTION_DRAG_STARTED");
                        break;
                    case  DragEvent.ACTION_DRAG_ENTERED:
                        Log.e("Sonuç", "ACTION_DRAG_ENTERED");
                        break;
                    case  DragEvent.ACTION_DRAG_EXITED:
                        Log.e("Sonuç", "ACTION_DRAG_EXITED");
                        break;
                    case  DragEvent.ACTION_DRAG_LOCATION:
                        Log.e("Sonuç", "ACTION_DRAG_LOCATION");
                        break;
                    case  DragEvent.ACTION_DRAG_ENDED:
                        Log.e("Sonuç", "ACTION_DRAG_ENDED");
                        break;
                    case  DragEvent.ACTION_DROP:
                        layoutParams.leftMargin = (int) event.getX();
                        layoutParams.topMargin = (int) event.getY();

                        View gorselNesne = (View) event.getLocalState();
                        ViewGroup eskiTasarimAlani = (ViewGroup) gorselNesne.getParent();
                        eskiTasarimAlani.removeView(gorselNesne);

                        RelativeLayout hedefTasariAlani = (RelativeLayout) v;
                        hedefTasariAlani.addView(gorselNesne, layoutParams);
                        gorselNesne.setVisibility(View.VISIBLE);

                        Log.e("Sonuç", "ACTION_DROP");
                        break;
                    default: break;
                }

                return true;
            }
        });
    }
}