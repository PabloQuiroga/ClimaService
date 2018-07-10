package com.pablo.climaservice.servicios;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;

public class BootReceiver extends BroadcastReceiver {

    private final int intervalDay = 1000*60*60*24; //24hs
    private final int intervalService = 1000*60*60*2; //2hs
    private final int intervalTest = 1000*60; //1 minuto
    private static final int ALARMA_MS = 5000; // 5 segundos

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "From Broadcast", Toast.LENGTH_SHORT).show();

        if(Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP) {

            Intent newIntent = new Intent(context, Clima.class);
            PendingIntent pendingIntent = PendingIntent.getService(context, 1, newIntent,
                    PendingIntent.FLAG_CANCEL_CURRENT);

            AlarmManager manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            manager.setInexactRepeating(AlarmManager.RTC, System.currentTimeMillis(), ALARMA_MS,
                    pendingIntent);
        }else{
            //TODO manejar el JobService aqui
        }
    }
}
