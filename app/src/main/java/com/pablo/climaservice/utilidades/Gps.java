package com.pablo.climaservice.utilidades;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

public class Gps implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private Context ctx;
    private final String TAG = Gps.class.getSimpleName();

    private Location location;
    private GoogleApiClient apiClient;
    private double latitud, longitud;

    public Gps(Context context){
        this.ctx = context;

        apiClient = new GoogleApiClient.Builder(ctx)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        apiClient.connect();

    }

    public double getLatitud() {
        return latitud;
    }

    private void updateCoords(){
        try {
            if (location.getProvider() != null) {
                latitud = location.getLatitude();
                longitud = location.getLongitude();
                Toast.makeText(ctx, "latitud: "+latitud +" longitud: "+longitud, Toast.LENGTH_LONG).show();// llega perfecto
            } else {
                Log.e(TAG, "Ubicacion no activa");
                return;
            }
        }catch (NullPointerException e){
            Log.e(TAG, "El movil posee desactivada la ubicacion");
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if (ActivityCompat.checkSelfPermission(ctx, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(ctx, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
        }
        location = LocationServices.FusedLocationApi.getLastLocation(apiClient);
        updateCoords();
    }

    @Override
    public void onConnectionSuspended(int i) {
        apiClient.disconnect();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
