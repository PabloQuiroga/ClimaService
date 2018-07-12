package com.pablo.climaservice.servicios;

import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;

import com.pablo.climaservice.MainActivity;
import com.pablo.climaservice.utilidades.Gps;
import com.pablo.climaservice.utilidades.PersonalNotification;

public class ClimaService extends IntentService {

    public static String ubi;
    public static int temp;
    PersonalNotification notificacion;
    private final String TAG = ClimaService.class.getSimpleName();

    public ClimaService() {
        super("ClimaService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        try {
            Handler handler = new Handler(getMainLooper());
            handler.post(new Runnable() {
                @Override
                public void run() {

                    Gps gps = new Gps(ClimaService.this); //aca si funca, llama al gps bien
                    String message = "Temperatura " + temp + "°C";

                    Intent targetIntent = new Intent(ClimaService.this, MainActivity.class);
                    PendingIntent pendingIntent = PendingIntent.getActivity(ClimaService.this, 0,targetIntent,0);

                    notificacion = new PersonalNotification(ClimaService.this, ubi, message, pendingIntent);
                    notificacion.lanzar();
                }
            });
        }catch (Exception e){
            Log.e(TAG, "some kind of error");
        }
    }
}
