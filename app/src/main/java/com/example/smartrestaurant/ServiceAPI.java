package com.example.smartrestaurant;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ServiceAPI {
    //Link API :https://reqres.in/api/login

    Gson gson = new GsonBuilder().create();

    ServiceAPI apiService = new Retrofit.Builder()
            .baseUrl("https://reqres.in/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ServiceAPI.class);

    @POST("login")
    Call<LoginDTO> login (@Body Account account);
}
