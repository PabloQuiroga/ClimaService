package com.pablo.climaservice.entidades;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;


public class Coord implements Serializable {

	private double lat;
	private double lon;

	public void setLat(float lat){
		this.lat = lat;
	}
	public double getLat(){
		return this.lat;
	}
	public void setLon(float lon){
		this.lon = lon;
	}
	public double getLon(){
		return this.lon;
	}


	/**
	 * Instantiate the instance using the passed jsonObject to set the properties values
	 */
	public Coord(JSONObject jsonObject){
		if(jsonObject == null){
			return;
		}
		try {
			lat = jsonObject.getDouble("lat");
			lon = jsonObject.getDouble("lon");
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
			jsonObject.put("lat", lat);
			jsonObject.put("lon", lon);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

}