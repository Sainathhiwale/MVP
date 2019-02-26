package com.example.mvp.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvp.MainActivity;
import com.example.mvp.R;
import com.example.mvp.data.DataManager;
import com.example.mvp.data.model.User;
import com.example.mvp.myapp.AppController;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginContract.LoginView {
    @Bind(R.id.etUser)
    EditText etUser;
    @Bind(R.id.etPassword)
    EditText etPassword;
    @Bind(R.id.btnLogin)
    Button btnLogin;
    private LoginPresenterImpl presenter;
    private DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        dataManager = ((AppController) getApplication()).getDataManager();
        if (dataManager.getLoggedInMode()) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            presenter = new LoginPresenterImpl(this);
        }
        // presenter = new LoginPresenterImpl(this);
    }


    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setLoginInData(User user) {
        if (user != null) {
            Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
            dataManager.setUserID(String.valueOf(user.getiD()));
            Intent homeIntent = new Intent(this, MainActivity.class);
            startActivity(homeIntent);

        }
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(LoginActivity.this,
                "Something went wrong please try again", Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.btnLogin)
    public void onViewClickde(View view) {
        getLoginUser();
    }

    private void getLoginUser() {
        presenter = new LoginPresenterImpl(this, new GetLoginIntractorImpl(etUser.getText().toString().trim(), etPassword.getText().toString().trim(), 1));
        presenter.validateLoginInFromServer();
    }
}
