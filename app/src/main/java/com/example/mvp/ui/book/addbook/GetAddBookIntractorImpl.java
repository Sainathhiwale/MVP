package com.example.mvp.ui.book.addbook;

import com.example.mvp.data.model.book.PostBook;
import com.example.mvp.data.network.AzureApiInterface;
import com.example.mvp.data.network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetAddBookIntractorImpl implements AddBookContract.GetAddBookInIntractor {
    private int id,pageCount;
    private String title,descripation,excerpt,publishDate;

    public GetAddBookIntractorImpl(int id, int pageCount, String title, String descripation, String excerpt, String publishDate) {
        this.id = id;
        this.pageCount = pageCount;
        this.title = title;
        this.descripation = descripation;
        this.excerpt = excerpt;
        this.publishDate = publishDate;
    }


    @Override
    public void getAddBkInfoData(final OnAddBkInFinishedListener onAddBkInFinishedListener) {
        AzureApiInterface azureApiInterface = RetrofitInstance.getRetrofitInstance().create(AzureApiInterface.class);
        Call<PostBook> bookCall = azureApiInterface.addBook(new PostBook(id,pageCount,title,descripation,excerpt,publishDate));
        bookCall.enqueue(new Callback<PostBook>() {
            @Override
            public void onResponse(Call<PostBook> call, Response<PostBook> response) {
                onAddBkInFinishedListener.onAddBkFinished(response.body());
            }

            @Override
            public void onFailure(Call<PostBook> call, Throwable t) {
              onAddBkInFinishedListener.onAddBkFailure(t);
            }
        });
    }
}
