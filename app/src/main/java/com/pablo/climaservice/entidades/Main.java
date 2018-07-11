package com.pablo.climaservice.entidades;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;


public class Main implements Serializable {

	private int humidity;
	private int pressure;
	private double temp;
	private int tempMax;
	private int tempMin;

	public void setHumidity(int humidity){
		this.humidity = humidity;
	}
	public int getHumidity(){
		return this.humidity;
	}
	public void setPressure(int pressure){
		this.pressure = pressure;
	}
	public int getPressure(){
		return this.pressure;
	}
	public void setTemp(float temp){
		this.temp = temp;
	}
	public double getTemp(){
		return this.temp;
	}
	public void setTempMax(int tempMax){
		this.tempMax = tempMax;
	}
	public int getTempMax(){
		return this.tempMax;
	}
	public void setTempMin(int tempMin){
		this.tempMin = tempMin;
	}
	public int getTempMin(){
		return this.tempMin;
	}


	/**
	 * Instantiate the instance using the passed jsonObject to set the properties values
	 */
	public Main(JSONObject jsonObject){
		if(jsonObject == null){
			return;
		}
		try {
			humidity = jsonObject.optInt("humidity");
			pressure = jsonObject.optInt("pressure");
			temp = jsonObject.getDouble("temp");
			tempMax = jsonObject.optInt("temp_max");
			tempMin = jsonObject.optInt("temp_min");
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
			jsonObject.put("humidity", humidity);
			jsonObject.put("pressure", pressure);
			jsonObject.put("temp", temp);
			jsonObject.put("temp_max", tempMax);
			jsonObject.put("temp_min", tempMin);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

}