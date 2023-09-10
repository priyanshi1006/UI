package com.example.actionbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

//    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar ac = getSupportActionBar();
        ac.setTitle("Kevin");
        ac.setIcon(R.drawable.icloggo_launcher_foreground);
        ac.setDisplayShowHomeEnabled(true);
        ac.setDisplayUseLogoEnabled(true);


    }
}