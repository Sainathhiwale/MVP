package com.example.mvp.data.network;

import com.example.mvp.data.model.SingleUsers;
import com.example.mvp.data.model.User;
import com.example.mvp.data.model.UserList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface AzureApiInterface {
    @Headers("Content-Type: application/json")
    @POST("api/Users")
    Call<User> loginUser(@Body User user);

    @GET("api/Users")
    Call<List<UserList>>getUserList();

    //get particular user just enter the user id
    @GET("api/Users/")
    Call<SingleUsers> getSingleUser(@Query("id") int id);
}
