package com.example.uipart;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;

    ViewPager2 vg;
    Adapter ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar ac = getSupportActionBar();
        ac.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        ac.setCustomView(R.layout.action_bar);
        ColorDrawable cd = new ColorDrawable(Color.parseColor("#8B74BD"));
        ac.setBackgroundDrawable(cd);
        vg = (ViewPager2) findViewById(R.id.vpg2);
//        TabLayout tl = findViewById(R.id.tl);
//        setupTabIcons();

        ad = new Adapter(this);
        vg.setAdapter(ad);


    }
}