package com.example.mvp.ui.authers.authersList;

import android.content.Context;

import com.example.mvp.data.model.authers.AuthorsList;
import com.example.mvp.data.network.AzureApiInterface;
import com.example.mvp.data.network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetAuthersIntractorImpl implements AuthersContract.GetAuthersInIntractor {
    private Context context;

    public GetAuthersIntractorImpl(Context context) {
        this.context = context;
    }

    @Override
    public void getAuthersListInfoData(final OnAuthersFinishedListener OnAuthersFinishedListener) {
        AzureApiInterface azureApiInterface = RetrofitInstance.getRetrofitInstance().create(AzureApiInterface.class);
        Call<List<AuthorsList>> callAutherList = azureApiInterface.getAutherList();
        callAutherList.enqueue(new Callback<List<AuthorsList>>() {
            @Override
            public void onResponse(Call<List<AuthorsList>> call, Response<List<AuthorsList>> response) {
                   OnAuthersFinishedListener.onASFinished(response.body());
            }

            @Override
            public void onFailure(Call<List<AuthorsList>> call, Throwable t) {
                OnAuthersFinishedListener.onASFailure(t);
            }
        });
    }
}
