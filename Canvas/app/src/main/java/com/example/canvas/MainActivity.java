package com.example.canvas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Drawing drawing = new Drawing(this);
//        drawing.setParams(2, "green");
//        setContentView(drawing);
        Drawing drawing = new Drawing(MainActivity.this);

        for(int i=0; i<10 ; i++) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    drawing.setParams(1, "red");
                    setContentView(drawing);
                }
            }, (i)*6000);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Drawing drawing = new Drawing(MainActivity.this);
                    drawing.setParams(2, "yellow");
                    setContentView(drawing);
                }
            }, i*6000 + 2000);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Drawing drawing = new Drawing(MainActivity.this);
                    drawing.setParams(3, "green");
                    setContentView(drawing);
                }
            }, i*6000 + 4000);


        }
//        private Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                Drawing drawing = new Drawing(MainActivity.this);
//                drawing.setParams(1, "red");
//                invalidate();
//                setContentView(drawing);
//                Handler.postDelayed(this, 2000);
//            }
//        }

    }

}