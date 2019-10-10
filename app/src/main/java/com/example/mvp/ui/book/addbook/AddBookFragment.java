package com.example.mvp.ui.book.addbook;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.mvp.R;
import com.example.mvp.data.model.book.PostBook;
import com.example.mvp.utils.CommonUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddBookFragment extends Fragment implements AddBookContract.AddBookView{


    @Bind(R.id.etBkId)
    EditText etBkId;
    @Bind(R.id.etTitle)
    EditText etTitle;
    @Bind(R.id.etBkDescription)
    EditText etBkDescription;
    @Bind(R.id.etBkPageCount)
    EditText etBkPageCount;
    @Bind(R.id.etBkExcerpt)
    EditText etBkExcerpt;
    @Bind(R.id.etBkPbsDte)
    EditText etBkPbsDte;
    @Bind(R.id.btnAddBook)
    Button btnAddBook;
    @Bind(R.id.linear_layout)
    LinearLayout linearLayout;
    @Bind(R.id.llAddBookLayout)
    LinearLayout llAddBookLayout;
    private AddBookPresenterImpl presenter;
    private int id;
    private int pageCount;
    private String title,descripation,excerpt,publishDate;
    public AddBookFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_book, container, false);
        ButterKnife.bind(this, view);
        return view;
    }



    @OnClick(R.id.btnAddBook)
    public void onViewClicked(View view) {
        int ids = view.getId();
        if (ids == R.id.btnAddBook){
            if (checkValidation()){
                addBook();
            }else {
                Snackbar snackbar = Snackbar.make(llAddBookLayout,"Please enter data!",Snackbar.LENGTH_SHORT);
                snackbar.show();
            }
        }
    }

    private boolean checkValidation() {
        boolean valid = true;

        return valid;
    }

    private void addBook() {
         id = Integer.parseInt(etBkId.getText().toString().trim());
         pageCount = Integer.parseInt(etBkPageCount.getText().toString().trim());
         title = etTitle.getText().toString().trim();
         descripation = etBkDescription.getText().toString().trim();
         excerpt = etBkExcerpt.getText().toString().trim();
         publishDate = etBkPbsDte.getText().toString().trim();
        presenter = new AddBookPresenterImpl(this,new GetAddBookIntractorImpl(id,pageCount,title,descripation,excerpt,publishDate));
        presenter.validateAddBookInFromServer();
    }

    @Override
    public void showProgress() {
         CommonUtils.startProgressBarDialog(getActivity(),"Adding new Book...");
    }

    @Override
    public void hideProgress() {
      CommonUtils.stopProgressBarDialog();
    }

    @Override
    public void setAddBookInfoData(PostBook postBook) {
        if (postBook!=null){
           Snackbar snackbar = Snackbar.make(llAddBookLayout,"Added"+postBook.getID(),Snackbar.LENGTH_SHORT);
           snackbar.show();
        }
    }

    @Override
    public void onFailure(Throwable throwable) {
      Snackbar snackbar =  Snackbar.make(llAddBookLayout, (CharSequence) throwable,Snackbar.LENGTH_SHORT);
      snackbar.show();
    }
}
