package com.example.mvp.data.network;

import com.example.mvp.data.model.book.BookInfoList;
import com.example.mvp.data.model.book.PostBook;
import com.example.mvp.data.model.user.AddUser;
import com.example.mvp.data.model.user.SingleUsers;
import com.example.mvp.data.model.user.User;
import com.example.mvp.data.model.user.UserList;
import com.example.mvp.data.model.authers.AddAuthers;
import com.example.mvp.data.model.authers.AuthorsList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface AzureApiInterface {
    @Headers("Content-Type: application/json")
    @POST("api/Users")
    Call<User> loginUser(@Body User user);
    // get users list in jsonarray
    @GET("api/Users")
    Call<List<UserList>>getUserList();

    //get particular user just enter the user id
    @GET("api/Users/")
    Call<SingleUsers> getSingleUser(@Query("id") int id);

    //send dynamic user id using put http request
    @PUT("api/Users/")
    Call<AddUser> addUsers(@Query("id")int id ,int userId,String userName,String password);

    //book module
    @POST("api/Books")
    Call<PostBook>addBook(@Body PostBook postBook);

    @GET("api/Books")
    Call<BookInfoList>getBookList();

    //Authers
    @GET("api/Authors")
    Call<List<AuthorsList>> getAutherList();

    @POST("api/Authors")
    Call<AddAuthers> addAuthers(@Body AddAuthers addAuthers);

}
