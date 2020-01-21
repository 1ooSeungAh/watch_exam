package com.example.watch_exam;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;

public class MainActivity extends AppCompatActivity {
    static final int BASIC_NOTIFICATION_ID=0;
    //기본 알림번호
    static final int ACTION_NOTIFICATION_ID=1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void showBasicNotification(View view){
        Notification notification = new Notification.Builder(this)
                .setContentTitle("BasicNotificationTitle")
                .setContentText("BasicNotificationText")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .build();

        NotificationManagerCompat notificationMenager = NotificationManagerCompat.from(this);

        notificationMenager.notify(BASIC_NOTIFICATION_ID,notification);

    }
    public void showActionNotification(View view){

        Intent viewIntent = new Intent(this,MainActivity.class);
        PendingIntent viewPendingIntent = PendingIntent.getActivity(this,0,viewIntent,0);

                Notification notification = new Notification.Builder(this)
                        .setContentTitle("ActionNotificationTitle")
                        .setContentText("ActionNotification Text")
                        .setSmallIcon(R.drawable.ic_launcher_foreground)
                        .addAction(R.drawable.ic_launcher_foreground,"ActionText",viewPendingIntent)
                        .build();

                NotificationManagerCompat.from(this).notify(ACTION_NOTIFICATION_ID,notification);
    }
}
