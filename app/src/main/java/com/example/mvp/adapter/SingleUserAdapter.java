package com.example.mvp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mvp.R;
import com.example.mvp.data.model.user.SingleUsers;
import com.example.mvp.utils.AppConstants;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SingleUserAdapter extends RecyclerView.Adapter<SingleUserAdapter.MyViewHolder> {
     private List<SingleUsers> singleUsersList;
     private Context context;
    private OnItemClickListener onItemClickListener;

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

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Bind(R.id.tvUserId)
        TextView tvUserId;
        @Bind(R.id.tvUserName)
        TextView tvUserName;
        @Bind(R.id.tvUserPass)
        TextView tvUserPass;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (onItemClickListener!=null){
                onItemClickListener.onItemClick(v, (SingleUsers) v.getTag());
            }
        }
    }
      public interface OnItemClickListener{
        void onItemClick(View view,SingleUsers position);
      }
}
