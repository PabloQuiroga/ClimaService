package com.pablo.climaservice;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.pablo.climaservice.utilidades.Gps;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private final String TAG = MainActivity.class.getSimpleName();
    ImageButton botonUpdate;
    TextView txtEstado, txtTemperatura, txtActualizado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonUpdate = (ImageButton)findViewById(R.id.btn_update);
        txtEstado = (TextView)findViewById(R.id.lbl_estado);
        txtTemperatura = (TextView)findViewById(R.id.lbl_temp); //lo muestra en formato "20°C"
        txtActualizado = (TextView)findViewById(R.id.lbl_actualizado); //formato esperado: 10/10/2010 10:10

        setPermission();
        
        botonUpdate.setOnClickListener(this);
    }

    private void setPermission() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED){

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        200);
            }
        }
    }

    @Override
    public void onClick(View v) {
        //TODO maneja la actualizacion de datos
        Gps gps = new Gps(this);
        Log.e(TAG, ""+gps.getLatitud()); //devuelve 0.0
    }
}
