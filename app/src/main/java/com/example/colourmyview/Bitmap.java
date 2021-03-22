package com.example.colourmyview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;

public class Bitmap extends AppCompatActivity {

    ImageView imageGraphics;
    android.graphics.Bitmap bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap);

        imageGraphics = findViewById(R.id.img_graphics);
        bg = android.graphics.Bitmap.createBitmap(900,1280, android.graphics.Bitmap.Config.RGB_565);
        imageGraphics.setImageBitmap(bg);

        Canvas cs = new Canvas(bg);
        Paint paint = new Paint();
        paint.setColor(Color.GRAY);
        paint.setTextSize(40);

        cs.drawText("Rectangle",100,50,paint);
        cs.drawRect(100,100,300,500,paint);

        cs.drawText("Circle",650,50,paint);
        cs.drawCircle(700,300,100,paint);


        cs.drawText("Square",100,700,paint);
        cs.drawRect(100,850,350,1150,paint);

        cs.drawText("Line",650,700,paint);
        cs.drawLine(700,850,700,1150,paint);
    }
}