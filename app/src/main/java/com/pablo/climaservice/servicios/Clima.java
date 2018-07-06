package com.pablo.climaservice.servicios;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

public class Clima extends IntentService {

    public Clima(){super("Clima");}

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.e("service", "handleIntent");
    }
}
