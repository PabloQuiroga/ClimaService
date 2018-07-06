package com.pablo.climaservice.servicios;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.pablo.climaservice.utilidades.LocationUtils;

public class Programador extends BroadcastReceiver {

    int interval = 1000*60*60*2; /* dos horas */

    @Override
    public void onReceive(Context context, Intent intent) {
        AlarmManager manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        Intent alarmIntent = new Intent(context, CheckClimaService.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, alarmIntent, 0);

        manager.setInexactRepeating(AlarmManager.RTC, System.currentTimeMillis(), interval, pendingIntent);

    }
}
