package com.example.mvp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mvp.R;
import com.example.mvp.data.model.SingleUsers;
import com.example.mvp.utils.AppConstants;

import java.security.PublicKey;
import java.util.List;

public class SingleUserAdapter extends RecyclerView.Adapter<SingleUserAdapter.MyViewHolder> {
     private List<SingleUsers> singleUsersList;
     private Context context;

    public SingleUserAdapter( Context context,List<SingleUsers> list) {
        this.context = context;
        this.singleUsersList = list;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.users_list,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SingleUsers users = singleUsersList.get(position);
        if (users.getID()==0){
            holder.tvUserId.setText(users.getID());
        }else {
            holder.tvUserId.setText(AppConstants.EMPTY);
        }if (users.getUserName()!=null){
            holder.tvUserName.setText(users.getUserName());
        }else {
            holder.tvUserName.setText(AppConstants.EMPTY);
        }if (users.getPassword()!=null){
            holder.tvUserPass.setText(users.getPassword());
        }else {
            holder.tvUserPass.setText(AppConstants.EMPTY);
        }
    }

    @Override
    public int getItemCount() {
        return singleUsersList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvUserId,tvUserName,tvUserPass;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUserId = (TextView)itemView.findViewById(R.id.tvUserId);
            tvUserName = (TextView)itemView.findViewById(R.id.tvUserName);
            tvUserPass = (TextView)itemView.findViewById(R.id.tvUserPass);
        }
    }
}
