package com.example.mvp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mvp.R;
import com.example.mvp.data.model.UserList;
import com.example.mvp.utils.AppConstants;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class UserAdatpter extends RecyclerView.Adapter<UserAdatpter.MyViewHolder> {
    private List<UserList> userLists ;
    public Context context;

    public UserAdatpter(Context context, List<UserList>userLists) {
        this.context = context;
        this.userLists = userLists;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.users_list, viewGroup, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

         holder.tvUserName.setText(userLists.get(position).getUserName());
         holder.tvUserPass.setText(userLists.get(position).getPassword());
       /* UserList userList = userLists.get(position);
         if (userList.getID()!=null) {
             holder.tvUserId.setText(userLists.get(position).getID());
         }else {
             holder.tvUserId.setText(AppConstants.EMPTY);
         }*/
        /*UserList userList = userLists.get(position);
        if (userList.getID() != null) {
            holder.tvUserId.setText(Integer.parseInt(String.valueOf(userLists.get(position).getID())));
        } else {
            holder.tvUserId.setText(AppConstants.EMPTY);
        }
        if (userList.getUserName() != null) {
            holder.tvUserName.setText(userLists.get(position).getUserName());
        } else {
            holder.tvUserName.setText(AppConstants.EMPTY);
        }
        if (userList.getPassword() != null) {
            holder.tvUserPass.setText(userLists.get(position).getPassword());
        } else {
            holder.tvUserPass.setText(AppConstants.EMPTY);
        }*/
    }

    @Override
    public int getItemCount() {
        return userLists.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
            @Bind(R.id.tvUserId)
            TextView tvUserId;
            @Bind(R.id.tvUserName)
            TextView tvUserName;
            @Bind(R.id.tvUserPass)
            TextView tvUserPass;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }
}
