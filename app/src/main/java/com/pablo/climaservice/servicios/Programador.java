package com.pablo.climaservice.servicios;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

public class Programador extends BroadcastReceiver {

    // TODO http://www.proyectosimio.com/es/programacion-android-broadcastreceiver/
    // http://www.vogella.com/tutorials/AndroidServices/article.html#exercise-define-and-consume-local-service
    // http://www.vogella.com/tutorials/android.html

    int interval = 1000*60;//*60*24; /* 24 horas */

    @Override
    public void onReceive(Context context, Intent intent) {
        //if(Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            Log.e("Broadcast", "");
            AlarmManager manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

            Intent alarmIntent = new Intent(context, Clima.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, alarmIntent, 0);

            manager.setInexactRepeating(AlarmManager.RTC, System.currentTimeMillis(), interval, pendingIntent);
        //}
    }
}
