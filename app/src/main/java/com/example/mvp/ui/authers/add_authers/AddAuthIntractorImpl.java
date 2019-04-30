package com.example.mvp.ui.authers.add_authers;

import com.example.mvp.data.model.authers.AddAuthers;
import com.example.mvp.data.network.AzureApiInterface;
import com.example.mvp.data.network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddAuthIntractorImpl implements AddAutherContract.GetAddAutherInIntractor {
     private int id;
     private int bookID;
     private String firstName;
     private String lastName;

    public AddAuthIntractorImpl(int id, int bookID, String firstName, String lastName) {
        this.id = id;
        this.bookID = bookID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public void getAddAutherInfoData(final OnAddAutherFinishedListener onAddAutherFinishedListener) {
        AzureApiInterface azureApiInterface  = RetrofitInstance.getRetrofitInstance().create(AzureApiInterface.class);
        Call<AddAuthers> addAuthersCall = azureApiInterface.addAuthers(new AddAuthers(id,bookID,firstName,lastName));
        addAuthersCall.enqueue(new Callback<AddAuthers>() {
            @Override
            public void onResponse(Call<AddAuthers> call, Response<AddAuthers> response) {
                onAddAutherFinishedListener.onAAFinished(response.body());
            }

            @Override
            public void onFailure(Call<AddAuthers> call, Throwable t) {
                onAddAutherFinishedListener.onAAFailure(t);
            }
        });
    }
}
