package com.company;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


public class HandleClient extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String api_Key = "235654c7d552697acbe7fdd64b5594b0";
        Scanner sc = new Scanner(System.in);
        String city = req.getParameter("city");
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


            String tempreature_convert = temprature + "°C";
            String wind_speed_convert = windspeed + "m/s";
            String wind_direction_convert = wind_direction + "°";
            String minimum_temp_convert = minimum_temp + "°C";
            String maximum_temp_convert = maximum_temp + "°C";
            String pressure_convert = pressure + "hPa";
            String humidity_convert = humidity + " %";
            String cloud_convert = cloud + "%";

            req.setAttribute("city",cityName);
            req.setAttribute("country",country);
            req.setAttribute("cloud",cloud_convert);
            req.setAttribute("temp",tempreature_convert);
            req.setAttribute("sunrise",sunrise);
            req.setAttribute("sunset",sunset);
            req.setAttribute("wind-speed",wind_speed_convert);
            req.setAttribute("wind-direction",wind_direction_convert);
            req.setAttribute("max-temp",maximum_temp_convert);
            req.setAttribute("min-temp",minimum_temp_convert);
            req.setAttribute("pressure",pressure_convert);
            req.setAttribute("humidity",humidity_convert);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("result.jsp");
            requestDispatcher.forward(req,resp);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
