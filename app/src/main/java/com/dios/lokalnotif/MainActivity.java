package com.dios.lokalnotif;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // identititas id unik untuk notification
    public static final int NOTIFICATION_ID = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportActionBar().setSubtitle("Belajar di okedroid.com");

    }

    public void tampilNotification(View view) {
        Intent intent = new Intent(this, Coba.class);
        //menginisialiasasi intent
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        /*
        Menmbangun atau mensetup Notification dengan NotificationCompat.Builder
         */
        NotificationCompat.Builder builder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher) //ikon notification
                .setContentTitle("Notifikasi Saya") //judul konten
                .setAutoCancel(true)//untuk menswipe atau menghapus notification
                .setContentText("Hello Okedroid")
                .setContentIntent(pendingIntent); //isi text

        /*
        Kemudian kita harus menambahkan Notification dengan menggunakan NotificationManager
         */

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(NOTIFICATION_ID, builder.build()
        );
    }



}
