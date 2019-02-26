package com.example.mvp.data.network;

import com.example.mvp.data.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface AzureApiInterface {
    @Headers("Content-Type: application/json")
    @POST("api/Users")
    Call<User> loginUser(@Body User user);
}
