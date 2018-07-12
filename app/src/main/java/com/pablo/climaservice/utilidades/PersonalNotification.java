package com.pablo.climaservice.utilidades;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.pablo.climaservice.R;

public class PersonalNotification {

    private Context ctx;
    NotificationManager manager;
    private final int ID_NOTIFICATION = 200;
    private final String NOTIFICATION = "Notificacion personalizada";
    private String titulo, mensaje;
    long vibrate[]={0,100,100}; //patron vibracion
    private PendingIntent pendingIntent;

    public PersonalNotification(Context context, String title, String message){
        this.ctx = context;
        manager = (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);
        this.titulo = title;
        this.mensaje = message;
    }
    public PersonalNotification(Context context, String title, String message, PendingIntent pendingIntent){
        this.ctx = context;
        manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        this.titulo = title;
        this.mensaje = message;
        this.pendingIntent = pendingIntent;
    }

    public void lanzar() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(
                ctx, NOTIFICATION)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle(titulo)
                .setContentText(mensaje)
                .setContentIntent(pendingIntent) //activity al pulsar
                //.setVibrate(vibrate) //desactivado para no notificar cuando este dormido el dispositivo
                .setWhen(System.currentTimeMillis());

        manager.notify(ID_NOTIFICATION, builder.build());
    }

    public void detener(){
        manager.cancel(ID_NOTIFICATION);
    }
}
