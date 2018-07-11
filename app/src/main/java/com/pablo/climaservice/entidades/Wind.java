package com.pablo.climaservice.entidades;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;


public class Wind implements Serializable {

	private int deg;
	private double speed;

	public void setDeg(int deg){
		this.deg = deg;
	}
	public int getDeg(){
		return this.deg;
	}
	public void setSpeed(float speed){
		this.speed = speed;
	}
	public double getSpeed(){
		return this.speed;
	}


	/**
	 * Instantiate the instance using the passed jsonObject to set the properties values
	 */
	public Wind(JSONObject jsonObject){
		if(jsonObject == null){
			return;
		}
		try {
			deg = jsonObject.optInt("deg");
			speed = jsonObject.getDouble("speed");
		}catch (JSONException e){
			e.printStackTrace();
		}
	}

	/**
	 * Returns all the available property values in the form of JSONObject instance where the key is the approperiate json key and the value is the value of the corresponding field
	 */
	public JSONObject toJsonObject()
	{
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("deg", deg);
			jsonObject.put("speed", speed);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

}