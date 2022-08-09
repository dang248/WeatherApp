package com.example.weatherapp.presentation.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.weatherapp.data.model.Forecast;
import com.example.weatherapp.data.repositories.ForecastRepository;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {
    private ForecastRepository repository;
    private MutableLiveData<Forecast> forecastData = new MutableLiveData<>();
    private MutableLiveData<String> message = new MutableLiveData<>();

    public MainViewModel(ForecastRepository repository){
        this.repository = repository;
    }

    public LiveData<Forecast> getForecastData(){
        return forecastData;
    }

    public LiveData<String> getMessage(){
        return message;
    }

    public void queryForecastByCityName(String cityName){
        repository.getForecastByCityName(cityName).enqueue(new Callback<Forecast>() {
            @Override
            public void onResponse(Call<Forecast> call, Response<Forecast> response) {
                if (response.isSuccessful()){
                    Forecast forecast = response.body();
                    forecastData.setValue(forecast);
                }else{
                    if (response.errorBody() != null){
                        try {
                            JSONObject jsonObject = new JSONObject(response.errorBody().string());
                            String textMessage = jsonObject.getString("message");
                            message.setValue(textMessage);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<Forecast> call, Throwable t) {

            }
        });
    }

}
