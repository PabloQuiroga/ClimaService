package com.pablo.climaservice.utilidades;

import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Pablo Daniel Quiroga on 13/3/2018.
 */
public class GpsAsynk extends AsyncTask<Double, Integer, String> /*implements GoogleApiClient.OnConnectionFailedListener, GoogleApiClient.ConnectionCallbacks*/ {

    private final String SERVICIO = "https://api.openweathermap.org/data/2.5/weather";
    private final String APPEND = "&units=metric&lang=es";
    private final String WEATHER_KEY = "&appid=3a3f49f2f43c0b4b6d8b534529ab4333";

    double latitud;
    double longitud;

    Callback callback;

    public GpsAsynk(Callback c) {
        this.callback = c;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }
    @Override
    protected String doInBackground(Double... coord) {
        this.latitud = coord[0];
        this.longitud = coord[1];
        return doConnection(setService(latitud,longitud));
    }
    @Override
    protected void onProgressUpdate(Integer... values) {
        callback.update();
    }
    @Override
    protected void onPostExecute(String s) {
        callback.completed(s);
    }

    private String setService(double x, double y){
        String res = SERVICIO + "?lat=" + x + "&lon=" + y + APPEND + WEATHER_KEY;
        return res;
    }
    private String doConnection(String serv){
        String retorno = null;
        try{
            //Crea la conexion
            URL servicio = new URL(serv);
            HttpsURLConnection conexion = (HttpsURLConnection) servicio.openConnection();

            //comprueba la conexion
            if(conexion.getResponseCode() == 200){
                //Convierte el InputStream en String
                InputStream is = conexion.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                StringBuilder result = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }
                retorno = result.toString();

                reader.close();
                is.close();
            }else{
                Toast.makeText(null, "Error al acceder al clima", Toast.LENGTH_SHORT);
            }
            conexion.disconnect();
        }
        catch (MalformedURLException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return retorno;
    }

}
