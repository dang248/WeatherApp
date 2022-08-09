package com.example.weatherapp.data.repositories;

import com.example.weatherapp.data.datasources.remote.ApiService;
import com.example.weatherapp.data.datasources.remote.RetrofitClient;
import com.example.weatherapp.data.model.Forecast;

import retrofit2.Call;

public class ForecastRepository {
    private ApiService apiService;

    public ForecastRepository(){
        apiService = RetrofitClient.getInstance().getApiService();
    }

    public Call<Forecast> getForecastByCityName(String cityName){
        return apiService.getForeCastByCityName("86183a23377ed034aef7aad102f43d64","metric",cityName);
    }
}
