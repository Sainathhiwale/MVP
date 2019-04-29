package com.example.mvp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvp.R;
import com.example.mvp.data.model.authers.AuthorsList;
import com.example.mvp.utils.AppConstants;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AuthersAdapter extends RecyclerView.Adapter<AuthersAdapter.MyViewHolder> {
    private Context context;
    private List<AuthorsList> authorsListList;

    public AuthersAdapter(Context context, List<AuthorsList> authorsListList) {
        this.context = context;
        this.authorsListList = authorsListList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.authers_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        AuthorsList authorsList = authorsListList.get(position);
        if (authorsList.getID() != null) {
            holder.tvId.setText(authorsList.getID()+"");
        } else {
            holder.tvId.setText(AppConstants.EMPTY);
        }
        if (authorsList.getIDBook() != null) {
            holder.tvIDBook.setText(authorsList.getIDBook()+"");
        }else {
            holder.tvIDBook.setText(AppConstants.EMPTY);
        }if (authorsList.getFirstName()!=null){
            holder.tvFirstName.setText(authorsList.getFirstName());
        }else {
            holder.tvFirstName.setText(AppConstants.EMPTY);
        }if (authorsList.getLastName()!=null){
            holder.tvLastName.setText(authorsList.getLastName());
        }else {
            holder.tvLastName.setText(AppConstants.EMPTY);
        }
    }

    @Override
    public int getItemCount() {
        return authorsListList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Bind(R.id.tvId)
        TextView tvId;
        @Bind(R.id.tvIDBook)
        TextView tvIDBook;
        @Bind(R.id.tvFirstName)
        TextView tvFirstName;
        @Bind(R.id.tvLastName)
        TextView tvLastName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context,authorsListList.get(0).getID(),Toast.LENGTH_SHORT).show();
        }
    }
}
