package com.pablo.climaservice.servicios;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.pablo.climaservice.utilidades.Gps;
import com.pablo.climaservice.utilidades.PersonalNotification;

public class ClimaService extends IntentService {

    public static String ubi;
    public static int temp;
    PersonalNotification notificacion;

    public ClimaService() {
        super("ClimaService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        Handler handler = new Handler(getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {

                Gps gps = new Gps(ClimaService.this); //aca si funca, llama al gps bien
                notificacion = new PersonalNotification(ClimaService.this, ubi, "Temperatura "+temp);
                notificacion.lanzar();

            }
        });
    }
}
