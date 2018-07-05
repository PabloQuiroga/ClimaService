package com.pablo.climaservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageButton botonUpdate;
    TextView txtEstado, txtTemperatura, txtActualizado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonUpdate = (ImageButton)findViewById(R.id.btn_update);
        txtEstado = (TextView)findViewById(R.id.lbl_estado);
        txtTemperatura = (TextView)findViewById(R.id.lbl_temp); //lo muestra en formato "20°C"
        txtActualizado = (TextView)findViewById(R.id.lbl_actualizado);
    }
}
