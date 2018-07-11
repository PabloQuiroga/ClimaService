package com.pablo.climaservice.entidades;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;


public class Sy implements Serializable {

	private String country;
	private int id;
	private double message;
	private int sunrise;
	private int sunset;
	private int type;

	public void setCountry(String country){
		this.country = country;
	}
	public String getCountry(){
		return this.country;
	}
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
	public void setMessage(float message){
		this.message = message;
	}
	public double getMessage(){
		return this.message;
	}
	public void setSunrise(int sunrise){
		this.sunrise = sunrise;
	}
	public int getSunrise(){
		return this.sunrise;
	}
	public void setSunset(int sunset){
		this.sunset = sunset;
	}
	public int getSunset(){
		return this.sunset;
	}
	public void setType(int type){
		this.type = type;
	}
	public int getType(){
		return this.type;
	}


	/**
	 * Instantiate the instance using the passed jsonObject to set the properties values
	 */
	public Sy(JSONObject jsonObject){
		if(jsonObject == null){
			return;
		}
		try {
			country = jsonObject.optString("country");
			id = jsonObject.optInt("id");
			message = jsonObject.getDouble("message");
			sunrise = jsonObject.optInt("sunrise");
			sunset = jsonObject.optInt("sunset");
			type = jsonObject.optInt("type");
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
			jsonObject.put("country", country);
			jsonObject.put("id", id);
			jsonObject.put("message", message);
			jsonObject.put("sunrise", sunrise);
			jsonObject.put("sunset", sunset);
			jsonObject.put("type", type);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

}