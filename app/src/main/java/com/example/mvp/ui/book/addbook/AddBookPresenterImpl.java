package com.example.mvp.ui.book.addbook;

import com.example.mvp.data.model.book.PostBook;

public class AddBookPresenterImpl implements AddBookContract.AddBookPresenter, AddBookContract.GetAddBookInIntractor.OnAddBkInFinishedListener{

    private AddBookContract.AddBookView addBookView;
    private AddBookContract.GetAddBookInIntractor getAddBookInIntractor;

    public AddBookPresenterImpl(AddBookContract.AddBookView addBookView, AddBookContract.GetAddBookInIntractor getAddBookInIntractor) {
        this.addBookView = addBookView;
        this.getAddBookInIntractor = getAddBookInIntractor;
    }

    @Override
    public void onDestory() {
      addBookView = null;
    }

    @Override
    public void validateAddBookInFromServer() {
      if(addBookView!=null){
           addBookView.showProgress();
          getAddBookInIntractor.getAddBkInfoData(this);
      }
    }

    @Override
    public void onAddBkFinished(PostBook postBook) {
       if (addBookView!=null){
           addBookView.hideProgress();
           addBookView.setAddBookInfoData(postBook);
       }
    }

    @Override
    public void onAddBkFailure(Throwable throwable) {
    if (addBookView!=null){
        addBookView.hideProgress();
        addBookView.onFailure(throwable);
    }
    }
}
