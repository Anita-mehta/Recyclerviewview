package com.bhanguz.amitdesign.util;

import com.bhanguz.amitdesign.model.Data;
import com.bhanguz.amitdesign.model.MyModelClass;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface RetrofitInterface {
    @GET("v1/prices/latest/?by_code=WTI_USD")
    abstract Call<MyModelClass> getlist(@Header("Authorization") String token);
}
