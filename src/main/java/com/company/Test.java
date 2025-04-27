package com.company;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        String api_Key = "235654c7d552697acbe7fdd64b5594b0";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter City Name :");
        String city = sc.next();
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + api_Key + "&units=metric";

        try{
            URL url1 = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url1.openConnection();
            httpURLConnection.setRequestMethod("GET");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();

            String response;
            while ((response = bufferedReader.readLine())!= null)
            {
                stringBuilder.append(response);
            }

            JsonObject jsonObject = JsonParser.parseString(stringBuilder.toString()).getAsJsonObject();
            String humanReadabel = new GsonBuilder().setPrettyPrinting().create().toJson(jsonObject);

            String cityName = jsonObject.get("name").getAsString();
            String temprature = jsonObject.getAsJsonObject("main").get("temp").getAsString();
            String country = jsonObject.getAsJsonObject("sys").get("country").getAsString();
            String sunrise = jsonObject.getAsJsonObject("sys").get("sunrise").getAsString();
            String sunset = jsonObject.getAsJsonObject("sys").get("sunset").getAsString();
            String cloud = jsonObject.getAsJsonObject("clouds").get("all").getAsString();
            String windspeed = jsonObject.getAsJsonObject("wind").get("speed").getAsString();
            String wind_direction = jsonObject.getAsJsonObject("wind").get("deg").getAsString();
            String minimum_temp = jsonObject.getAsJsonObject("main").get("temp_min").getAsString();
            String maximum_temp = jsonObject.getAsJsonObject("main").get("temp_max").getAsString();
            String pressure = jsonObject.getAsJsonObject("main").get("pressure").getAsString();
            String humidity = jsonObject.getAsJsonObject("main").get("humidity").getAsString();
            System.out.println(cloud);
            System.out.println(humanReadabel);
            String city_convert = cityName;
            String tempreature_convert = temprature + " " + "°C";
            System.out.println(tempreature_convert);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}