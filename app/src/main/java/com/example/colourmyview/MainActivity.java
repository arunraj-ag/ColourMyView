package com.example.colourmyview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView box_one,box_two,box_three,box_four,box_five;

    Button change_btn,notification_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        box_one = findViewById(R.id.box_one_txt);
        box_two = findViewById(R.id.box_two_txt);
        box_three = findViewById(R.id.box_three_txt);
        box_four = findViewById(R.id.box_four_txt);
        box_five = findViewById(R.id.box_five_txt);
        change_btn = findViewById(R.id.button_change_txt);
        notification_btn = findViewById(R.id.notification_btn);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("A Notification","A Notification",NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        change_btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                box_one.setText("NOT A BOX");
                box_two.setText("NOT A BOX");
                box_three.setText("NOT A BOX");
                box_four.setText("NOT A BOX");
                box_five.setText("NOT A BOX");
                return  true;
            }
        });
    }

    public void box_one_method(View v){
        v.setBackgroundColor(Color.RED);
    }
    public void box_two_method(View v){
        v.setBackgroundColor(Color.GREEN);
    }
    public void box_three_method(View v){
        v.setBackgroundColor(Color.BLUE);
    }
    public void box_four_method(View v){
        v.setBackgroundColor(Color.BLACK);
    }
    public void box_five_method(View v){
        v.setBackgroundColor(Color.GRAY);
    }


    public void change_text(View v){
        box_one.setText("BOX");
        box_two.setText("BOX");
        box_three.setText("BOX");
        box_four.setText("BOX");
        box_five.setText("BOX");
    }

    public void notification_method(View v){
        String msg = "These are all Boxes";
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this,"A Notification");
                builder.setSmallIcon(R.drawable.notify_icon_black)
                .setContentTitle("A Box Notification")
                .setContentText(msg)
                .setAutoCancel(true);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
        managerCompat.notify(2,builder.build());

        /*Intent intent = new Intent(MainActivity.this,Notification.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("message",msg);

        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,builder.build());*/

    }
    public void bitmap_intent_method(View v){
        Intent intent = new Intent(MainActivity.this, com.example.colourmyview.Bitmap.class);
        startActivity(intent);
        finish();
    }

    public void database_intent_method(View v){
        Intent intent = new Intent(MainActivity.this, com.example.colourmyview.Database.class);
        startActivity(intent);
        finish();
    }
}