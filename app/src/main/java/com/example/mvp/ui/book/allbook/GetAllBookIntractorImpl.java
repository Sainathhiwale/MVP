package com.example.mvp.ui.book.allbook;

import android.support.v4.app.FragmentActivity;

import com.example.mvp.data.model.book.BookInfoList;
import com.example.mvp.data.network.AzureApiInterface;
import com.example.mvp.data.network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetAllBookIntractorImpl implements AllBookContract.GetAllBookIntractor {

    public GetAllBookIntractorImpl() {
    }

    @Override
    public void getAllBookInfoData(final OnAllBKFinishedListener onAllBKFinishedListener) {
        AzureApiInterface azureApiInterface = RetrofitInstance.getRetrofitInstance().create(AzureApiInterface.class);
        Call<BookInfoList> bookInfoListCall = azureApiInterface.getBookList();
        bookInfoListCall.enqueue(new Callback<BookInfoList>() {
            @Override
            public void onResponse(Call<BookInfoList> call, Response<BookInfoList> response) {
                onAllBKFinishedListener.onAllBkFinished(response.body());
            }

            @Override
            public void onFailure(Call<BookInfoList> call, Throwable t) {
                onAllBKFinishedListener.onAllBkFailure(t);
            }
        });
    }
}
