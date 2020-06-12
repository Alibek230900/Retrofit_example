package com.example.retrofit_example.Retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Serializable;

import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient implements Serializable {
    public static final String BASE_URL="https://newsapi.org";
    public static Retrofit retrofit=null;

    //newsapi.org/v2/sources?language=en&apiKey=b068400a84804f40bcc68394883de5c

    public static Retrofit getApiClient(){
        if (retrofit==null){
            Gson gson=new GsonBuilder().setLenient().create();
            retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        }
        return retrofit;
    }
    public static String getApiUrl(String source,String apiKey){
        StringBuilder apiUrl = new StringBuilder("https://newsapi.org/v2/top-headlines?sources=");
        return apiUrl.append(source).append("&apiKey").append(apiKey).toString();
    }
}
