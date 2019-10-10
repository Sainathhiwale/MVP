package com.example.mvp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvp.R;
import com.example.mvp.data.model.book.BookInfoList;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.MyBookViewHolder>{
    private List<BookInfoList> bookInfoLists;
    private Context context;

    public BookAdapter( Context context,List<BookInfoList> bookInfoLists) {
        this.context = context;
        this.bookInfoLists = bookInfoLists;
    }

    @NonNull
    @Override
    public MyBookViewHolder onCreateViewHolder(@NonNull ViewGroup parenrt, int position) {
        View view = LayoutInflater.from(parenrt.getContext()).inflate(R.layout.book_list,parenrt,false);
        return new MyBookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyBookViewHolder holder, int position) {
        BookInfoList bookInfoList = bookInfoLists.get(position);

    }

    @Override
    public int getItemCount() {
        if (bookInfoLists!=null){
         return bookInfoLists.size();
        }else{
            return 0;
        }
    }

    public class MyBookViewHolder extends RecyclerView.ViewHolder{
        public MyBookViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
