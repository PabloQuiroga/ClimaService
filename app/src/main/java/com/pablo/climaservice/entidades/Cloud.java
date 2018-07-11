package com.pablo.climaservice.entidades;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;


public class Cloud implements Serializable {

	private int all;

	public void setAll(int all){
		this.all = all;
	}
	public int getAll(){
		return this.all;
	}


	/**
	 * Instantiate the instance using the passed jsonObject to set the properties values
	 */
	public Cloud(JSONObject jsonObject){
		if(jsonObject == null){
			return;
		}
		all = jsonObject.optInt("all");
	}

	/**
	 * Returns all the available property values in the form of JSONObject instance where the key is the approperiate json key and the value is the value of the corresponding field
	 */
	public JSONObject toJsonObject()
	{
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("all", all);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

}