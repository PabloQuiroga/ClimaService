package com.pablo.climaservice.utilidades;

/**
 * Created by pablo.quiroga on 3/13/2018.
 */

public interface Callback {
    public void starting();
    public void completed(String res);
    public void completedWithErrors(Exception e);
    public void update();
}
