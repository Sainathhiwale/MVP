package com.example.mvp.ui.user.add_users;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvp.R;
import com.example.mvp.data.model.AddUser;
import com.example.mvp.utils.CommonUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddUsersFragment extends Fragment implements AddUserContract.AddUserView {

    @Bind(R.id.etUserId)
    EditText etUserId;
    @Bind(R.id.user_id_inputlayout)
    TextInputLayout userIdInputlayout;
    @Bind(R.id.etNameId)
    EditText etNameId;
    @Bind(R.id.etUsrName)
    EditText etUsrName;
    @Bind(R.id.etUsrPassword)
    EditText etUsrPassword;
    @Bind(R.id.btnAddUser)
    Button btnAddUser;
    @Bind(R.id.rvList)
    RecyclerView rvList;
    LinearLayoutManager linearLayoutManager;
    AddUserPresenterImpl presenter;
    public AddUsersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_users, container, false);
        ButterKnife.bind(this, view);
        initData();
        return view;
    }

    private void initData() {
        linearLayoutManager = new LinearLayoutManager(getActivity());
        rvList.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void showProgress() {
       // CommonUtils.startProgressBarDialog(getActivity(),"add user in list..wait");

    }

    @Override
    public void hideProgress() {
      CommonUtils.stopProgressBarDialog();
    }

    @Override
    public void setAdduserInData(AddUser addUser) {
       if (addUser!=null){

       }
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(getActivity(), "something went wrong!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.btnAddUser)
    public void onViewClicked() {
        String userId = etUserId.getText().toString().trim();
        int id = Integer.parseInt(userId);
        String nameId = etNameId.getText().toString().trim();
        int namesId = Integer.parseInt(nameId);
        presenter = new AddUserPresenterImpl(this,new AddUserIntractorImpl(getActivity(),id,namesId,etUsrName.getText().toString().trim(),etUsrPassword.getText().toString().trim()));
        presenter.validateAddUserInFromServer();
    }
}
