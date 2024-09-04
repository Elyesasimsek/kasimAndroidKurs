package com.example.tablayoutkuullanimi;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private ArrayList<Fragment> fragmentListesi = new ArrayList<>();
    private ArrayList<String> fragmentBaslikListesi = new ArrayList<>();

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

        tabLayout =findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager2);

        fragmentListesi.add(new FragmentBirinci());
        fragmentListesi.add(new FragmentIkinci());
        fragmentListesi.add(new FragmentUcuncu());

        MyViewPagerAdapter adapter = new MyViewPagerAdapter(this);
        viewPager2.setAdapter(adapter);

        fragmentBaslikListesi.add("Bir");
        fragmentBaslikListesi.add("İki");
        fragmentBaslikListesi.add("Üç");

        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) ->tab.setText(fragmentBaslikListesi.get(position))).attach();

        tabLayout.getTabAt(0).setIcon(R.drawable.resim);
    }

    private class MyViewPagerAdapter extends FragmentStateAdapter{

        public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return fragmentListesi.get(position);
        }

        @Override
        public int getItemCount() {
            return fragmentListesi.size();
        }
    }
}