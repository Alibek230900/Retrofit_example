package com.example.retrofit_example.Retrofit;

import com.example.retrofit_example.AppConstants;
import com.example.retrofit_example.Models.Website;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("v2/sources?language=en&apiKey"+ AppConstants.API_KEY);
    Call<Website> getSources();

}
