package com.example.mvp.ui.authers.add_authers;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.mvp.R;
import com.example.mvp.data.model.authers.AddAuthers;
import com.example.mvp.utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddAutherFragment extends Fragment implements AddAutherContract.AddAutherView{

    @Bind(R.id.etID)
    EditText etID;
    @Bind(R.id.etBookId)
    EditText etBookId;
    @Bind(R.id.etFirstName)
    EditText etFirstName;
    @Bind(R.id.etLastName)
    EditText etLastName;
    @Bind(R.id.btnAddAuthers)
    Button btnAddAuthers;
    @Bind(R.id.rLayout)
    RelativeLayout rLayout;
    @Bind(R.id.listview)
    ListView listview;
    AddAuthPresenterImpl presenter;
    List list;
    public AddAutherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_auther, container, false);
        ButterKnife.bind(this, view);
        //initData();
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.btnAddAuthers)
    public void onBtnAddAuthersClicked() {
        addAuthers();
    }

    private void addAuthers() {
        String ids = etID.getText().toString().trim();
        int iD = Integer.parseInt(ids);
        String bkID = etBookId.getText().toString().trim();
        int bookID = Integer.parseInt(bkID);
    presenter = new AddAuthPresenterImpl(this,new AddAuthIntractorImpl(iD,
            bookID,etFirstName.getText().toString(),etLastName.getText().toString()));
    }

    @Override
    public void showProgress() {
        CommonUtils.startProgressBarDialog(getActivity(),"Adding Authers...");
    }

    @Override
    public void hideProgress() {
       CommonUtils.stopProgressBarDialog();
    }

    @Override
    public void setAutherInData(AddAuthers addAuthers) {
       if (addAuthers!=null){
           list = new ArrayList();
           Toast.makeText(getActivity(), "Add Auther Successfully", Toast.LENGTH_SHORT).show();
           list.add(addAuthers.getFirstName());
           for (int i=0;i<=list.size();i++){
               ArrayAdapter<AddAuthers> arrayAdapter = new ArrayAdapter<AddAuthers>(getActivity(), android.R.layout.simple_list_item_1, list);
               listview.setAdapter(arrayAdapter);
           }
       }
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(getActivity(), "Something went wrong!", Toast.LENGTH_SHORT).show();
    }
}
