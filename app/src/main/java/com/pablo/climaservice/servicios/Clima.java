package com.pablo.climaservice.servicios;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.pablo.climaservice.utilidades.Gps;

public class Clima extends IntentService {

    int intervalDay = 1000*60*60*24; //24hs
    int intervalService = 1000*60*60*2; //2hs
    int intervalTest = 1000*60; //1 minuto

    public Clima(){
        super("Clima");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.e("service", "handleIntent");

        Handler handler = new Handler(getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                //Toast.makeText(Clima.this, "HandleIntent", Toast.LENGTH_SHORT).show();

                Gps gps = new Gps(Clima.this);
                String lat = String.valueOf(gps.getLatitud());
                Toast.makeText(Clima.this, "latitud: "+lat, Toast.LENGTH_SHORT).show();
            }
        });

        /*AlarmManager manager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);

        Intent alarmIntent = new Intent(this, Clima.class);
        PendingIntent pendingIntent = PendingIntent.getService(this, 0, alarmIntent, 0);

        manager.setRepeating(AlarmManager.RTC, System.currentTimeMillis(), intervalTest, pendingIntent);*/
    }
}
