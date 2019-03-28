package com.example.mvp.ui.get_user;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
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
    @Bind(R.id.etUserId)
    EditText etUserId;
    @Bind(R.id.btnGetUser)
    Button btnGetUser;
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
        initView();
        presenter = new SinglePresenterImpl();
        return view;
    }

    private void initView() {

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
            presenter = new SinglePresenterImpl(this, new SingleUserIntractorImpl(id));
            presenter.requestDataForSingleUser();
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
             ArrayAdapter<SingleUsers> arrayAdapter = new ArrayAdapter<SingleUsers>(getActivity(),android.R.layout.simple_list_item_1,list);
             lViewUser.setAdapter(arrayAdapter);

            /* String username = singleUsers.getUserName();
             Log.d(TAG, "setSingleUserInfoData: "+username);
             Toast.makeText(getActivity(), "User Name"+username, Toast.LENGTH_SHORT).show();*/
         }
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(getActivity(), "something went wrong!", Toast.LENGTH_SHORT).show();
    }
}
