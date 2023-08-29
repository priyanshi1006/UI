package com.example.canvas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.view.View;

public class Drawing extends View {

    private Paint brush;
    private Bitmap bitmap;
    private LinearGradient linearGradient;
    float pos;
    public Drawing(Context context) {
        super((Context) context);
        init();
    }

    public void init()
    {
        //bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background);
        //linearGradient = new LinearGradient(0,0,100,100, Color.GREEN,Color.RED, Shader.TileMode.MIRROR);
        brush= new Paint(Paint.ANTI_ALIAS_FLAG);
        //brush.setColor(Color.parseColor("black"));

    }

    public void setParams(int x, String color)
    {
        brush.setColor(Color.parseColor(color));
        if(x == 1)
            pos = 6;
        if(x == 2)
            pos = 2;
        if(x == 3)
            pos = 1.33F;
    }
    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawCircle(getMeasuredWidth()/2, getMeasuredHeight()/pos, 308f, brush);
        canvas.save();
        super.onDraw(canvas);
    }
}
