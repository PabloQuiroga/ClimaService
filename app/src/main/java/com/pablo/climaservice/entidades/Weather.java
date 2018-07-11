package com.pablo.climaservice.entidades;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;


public class Weather implements Serializable {

	private String description;
	private String icon;
	private int id;
	private String main;

	public void setDescription(String description){
		this.description = description;
	}
	public String getDescription(){
		return this.description;
	}
	public void setIcon(String icon){
		this.icon = icon;
	}
	public String getIcon(){
		return this.icon;
	}
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
	public void setMain(String main){
		this.main = main;
	}
	public String getMain(){
		return this.main;
	}


	/**
	 * Instantiate the instance using the passed jsonObject to set the properties values
	 */
	public Weather(JSONObject jsonObject){
		if(jsonObject == null){
			return;
		}
		description = jsonObject.optString("description");
		icon = jsonObject.optString("icon");
		id = jsonObject.optInt("id");
		main = jsonObject.optString("main");
	}

	/**
	 * Returns all the available property values in the form of JSONObject instance where the key is the approperiate json key and the value is the value of the corresponding field
	 */
	public JSONObject toJsonObject()
	{
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("description", description);
			jsonObject.put("icon", icon);
			jsonObject.put("id", id);
			jsonObject.put("main", main);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

}