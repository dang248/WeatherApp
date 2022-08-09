package com.example.weatherapp.data.datasources.remote;

import com.example.weatherapp.data.model.Forecast;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("data/2.5/weather")
    Call<Forecast> getForeCastByCityName(
            @Query("appid") String appId,
            @Query("units") String units,
            @Query("q") String cityName
    );
}
