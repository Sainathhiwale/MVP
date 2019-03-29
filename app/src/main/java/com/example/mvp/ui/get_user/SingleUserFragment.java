package com.example.mvp.ui.get_user;


import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvp.R;
import com.example.mvp.adapter.SingleUserAdapter;
import com.example.mvp.data.model.SingleUsers;
import com.example.mvp.utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class SingleUserFragment extends Fragment implements SingleContract.SingleView{
    private static final String TAG = "SingleUserFragment";
    @Bind(R.id.lViewUser)
    ListView lViewUser;
   /* @Bind(R.id.rvList)
    RecyclerView rvList;*/
    @Bind(R.id.etUserId)
    EditText etUserId;
    @Bind(R.id.btnGetUser)
    Button btnGetUser;
    @Bind(R.id.llinerlayout)
    LinearLayout llinerlayout;
    private SinglePresenterImpl presenter;
    private SingleUserAdapter adapter;

    public SingleUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_get_user, container, false);
        ButterKnife.bind(this,view);
        presenter = new SinglePresenterImpl();
        return view;
    }



    @OnClick(R.id.btnGetUser)
    public void onViewClicked(View view){
        switch (view.getId()){
            case R.id.btnGetUser:
                initData();
                break;

        }
    }
    private void initData() {
        if (getActivity()!=null) {
            String userId = etUserId.getText().toString().trim();
            int id  = Integer.parseInt(userId);
            if (id>0 && id<10) {
                presenter = new SinglePresenterImpl(this, new SingleUserIntractorImpl(id));
                presenter.requestDataForSingleUser();
            }else {
                Snackbar snackbar = Snackbar.make(llinerlayout,"Invalid number:"+id,Snackbar.LENGTH_SHORT);
                View view = snackbar.getView();
                TextView textView = (TextView)view.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.RED);
                snackbar.show();
                //Toast.makeText(getActivity(), "Invalid number:"+id, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void showProgress() {
        CommonUtils.startProgressBarDialog(getActivity(),"getting user id");
    }

    @Override
    public void hideProgress() {
      CommonUtils.stopProgressBarDialog();
    }

    @Override
    public void setSingleUserInfoData(SingleUsers singleUsers) {
         if (singleUsers!=null){
             List  list = new ArrayList();
             list.add(singleUsers.getPassword());
             list.add(singleUsers.getUserName());
             list.add(singleUsers.getID());
             for (int i=0;i<list.size();i++){
                 ArrayAdapter<SingleUsers> arrayAdapter = new ArrayAdapter<SingleUsers>(getActivity(),android.R.layout.simple_list_item_1,list);
                 lViewUser.setAdapter(arrayAdapter);
             }


         }
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(getActivity(), "something went wrong!", Toast.LENGTH_SHORT).show();
    }
}
