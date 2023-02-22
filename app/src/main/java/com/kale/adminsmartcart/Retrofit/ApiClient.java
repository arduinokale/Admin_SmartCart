package com.kale.adminsmartcart.Retrofit;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String BASE_URL = "https://smartshoppingcart0223.000webhostapp.com/";
    public static Retrofit retrofit = null;

    public static Retrofit getApiClient(){
        OkHttpClient client = new OkHttpClient();

               Gson gson = new GsonBuilder()
                       .setLenient()
                       .create();

        if (retrofit==null){

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }

}