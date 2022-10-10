package com.bhanguz.amitdesign.util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private String BASE_URL = "https://api.oilpriceapi.com/";
    private static RetrofitClient instance;
    public  RetrofitInterface services;

    private RetrofitClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        services=retrofit.create(RetrofitInterface.class);
    }
    public static RetrofitClient getInstance(){

        if (instance== null){
            instance=new RetrofitClient();
        }
        return instance;
    }

}
