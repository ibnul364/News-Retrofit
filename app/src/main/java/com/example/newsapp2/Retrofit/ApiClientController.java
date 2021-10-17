package com.example.newsapp2.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClientController {

    public static final String  BASE_URL = "https://newsapi.org/v2/";
    public static ApiClientController apiClient;
    public static Retrofit retrofit;

    ApiClientController(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized ApiClientController getInstance() {
        if(apiClient==null){
            apiClient = new ApiClientController();
        }
        return apiClient;
    }

    public ApiInterface getApi() {
        return retrofit.create(ApiInterface.class);
    }

}
