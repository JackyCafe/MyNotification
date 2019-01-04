package com.example.linyanheng.mynotification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private NotificationManager mgr;
    private NotificationCompat.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mgr = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
            NotificationChannel notificationChannel = new NotificationChannel("YH","custom",NotificationManager.IMPORTANCE_HIGH);
            mgr.createNotificationChannel(notificationChannel);
        }

    }

    public void Test1(View view) {
        builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("重要通知").setContentText("通知內容")
                .setSmallIcon(R.drawable.ic_stat_name)
                .setChannelId("YH");

        mgr.notify(1,builder.build());
    }

    public void Test2(View view) {
        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(),R.mipmap.yh);
        builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("重要通知")
                .setContentText("通知內容")
                .setSmallIcon(R.drawable.ic_stat_name)
                .setLargeIcon(largeIcon)
                .setSubText("Sub Text")
                .setChannelId("YH").setTicker("Ticker");


        mgr.notify(2,builder.build());

    }

    public void Test3(View view) {
        Intent resultIntent = new Intent(this,ResultActivit.class);
        String title = "Hello Jacky";
        String content = "This is a notification";
        Email email = new Email(title,content);
        Bundle bundle = new Bundle();
        bundle.putSerializable("email",email);
        resultIntent.putExtras(bundle);


        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(ResultActivit.class);
        stackBuilder.addNextIntent(resultIntent);

        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);

        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(),R.mipmap.yh);
        builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("重要通知")
                .setContentText("通知內容")
                .setSmallIcon(R.drawable.ic_stat_name)
                .setLargeIcon(largeIcon)
                .setSubText("Sub Text")
                .setChannelId("YH")
                .setContentIntent(resultPendingIntent)
                .setTicker("Ticker");


        mgr.notify(3,builder.build());

    }
}
