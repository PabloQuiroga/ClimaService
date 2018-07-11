package com.pablo.climaservice.entidades;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Clima implements Serializable {

	private String base;
	private Cloud clouds;
	private int cod;
	private Coord coord;
	private int dt;
	private int id;
	private Main main;
	private String name;
	private Sy sys;
	private int visibility;
	private List<Weather> weather; //Weather[]
	private Wind wind;

	public void setBase(String base){
		this.base = base;
	}
	public String getBase(){
		return this.base;
	}
	public void setClouds(Cloud clouds){
		this.clouds = clouds;
	}
	public Cloud getClouds(){
		return this.clouds;
	}
	public void setCod(int cod){
		this.cod = cod;
	}
	public int getCod(){
		return this.cod;
	}
	public void setCoord(Coord coord){
		this.coord = coord;
	}
	public Coord getCoord(){
		return this.coord;
	}
	public void setDt(int dt){
		this.dt = dt;
	}
	public int getDt(){
		return this.dt;
	}
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
	public void setMain(Main main){
		this.main = main;
	}
	public Main getMain(){
		return this.main;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setSys(Sy sys){
		this.sys = sys;
	}
	public Sy getSys(){
		return this.sys;
	}
	public void setVisibility(int visibility){
		this.visibility = visibility;
	}
	public int getVisibility(){
		return this.visibility;
	}
	public void setWeather(List<Weather> weather){
		this.weather = weather;
	}
	public List<Weather> getWeather(){
		return this.weather;
	}
	public void setWind(Wind wind){
		this.wind = wind;
	}
	public Wind getWind(){
		return this.wind;
	}


	/**
	 * Instantiate the instance using the passed jsonObject to set the properties values
	 */
	public Clima(JSONObject jsonObject){
		if(jsonObject == null){
			return;
		}
		base = jsonObject.optString("base");
		clouds = new Cloud(jsonObject.optJSONObject("clouds"));
		cod = jsonObject.optInt("cod");
		coord = new Coord(jsonObject.optJSONObject("coord"));
		dt = jsonObject.optInt("dt");
		id = jsonObject.optInt("id");
		main = new Main(jsonObject.optJSONObject("main"));
		name = jsonObject.optString("name");
		sys = new Sy(jsonObject.optJSONObject("sys"));
		visibility = jsonObject.optInt("visibility");
		wind = new Wind(jsonObject.optJSONObject("wind"));
		JSONArray weatherJsonArray = jsonObject.optJSONArray("weather");
		if(weatherJsonArray != null){
			List<Weather> weatherArrayList = new ArrayList<>();
			for (int i = 0; i < weatherJsonArray.length(); i++) {
				JSONObject weatherObject = weatherJsonArray.optJSONObject(i);
				weatherArrayList.add(new Weather(weatherObject));
			}
			weather = weatherArrayList;
		}
	}

	/**
	 * Returns all the available property values in the form of JSONObject instance where the key is the approperiate json key and the value is the value of the corresponding field
	 */
	public JSONObject toJsonObject()
	{
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("base", base);
			jsonObject.put("clouds", clouds.toJsonObject());
			jsonObject.put("cod", cod);
			jsonObject.put("coord", coord.toJsonObject());
			jsonObject.put("dt", dt);
			jsonObject.put("id", id);
			jsonObject.put("main", main.toJsonObject());
			jsonObject.put("name", name);
			jsonObject.put("sys", sys.toJsonObject());
			jsonObject.put("visibility", visibility);
			jsonObject.put("wind", wind.toJsonObject());
			if(weather != null && weather.size() > 0){
				JSONArray weatherJsonArray = new JSONArray();
				for(Weather weatherElement : weather){
					weatherJsonArray.put(weatherElement.toJsonObject());
				}
				jsonObject.put("weather", weatherJsonArray);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

}