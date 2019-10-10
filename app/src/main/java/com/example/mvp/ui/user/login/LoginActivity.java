package com.example.mvp.ui.user.login;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvp.ui.main.MainActivity;
import com.example.mvp.R;
import com.example.mvp.data.DataManager;
import com.example.mvp.data.model.user.User;
import com.example.mvp.myapp.AppController;
import com.example.mvp.utils.AppConstants;
import com.example.mvp.utils.CommonUtils;

import java.util.regex.Pattern;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.disposables.CompositeDisposable;

public class LoginActivity extends AppCompatActivity implements LoginContract.LoginView {
    @Bind(R.id.etUser)
    EditText etUser;
    @Bind(R.id.etPassword)
    EditText etPassword;
    @Bind(R.id.btnLogin)
    Button btnLogin;
    @Bind(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;
    private CompositeDisposable disposable = new CompositeDisposable();

    private LoginPresenterImpl presenter;
    private DataManager dataManager;

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$");

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
    }


    @Override
    public void showProgress() {
        CommonUtils.startProgressBarDialog(this, "Login in.......");
    }

    @Override
    public void hideProgress() {
        CommonUtils.stopProgressBarDialog();
    }

    @Override
    public void setLoginInData(User user) {
        if (user != null) {
            Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
            dataManager.setUserID(String.valueOf(user.getiD()));
            dataManager.setUserName(user.getUserName());
            Intent homeIntent = new Intent(this, MainActivity.class);
            homeIntent.putExtra(AppConstants.USERNAME,etUser.getText().toString().trim());
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
        if (!validateEmail() | !validatePassword()) {
            return;
        }
        getLoginUser();

    }

    public boolean validateEmail() {
        String emailInput = etUser.getText().toString().trim();
        if (emailInput.isEmpty()) {
            etUser.setError("Field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            etUser.setError("Please enter a valid email address");
            return false;
        } else {
            etUser.setError(null);
            return true;
        }
    }

    public boolean validatePassword() {
        String passwordInput = etPassword.getText().toString().trim();
        if (passwordInput.isEmpty()) {
            etPassword.setError("Field can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            etPassword.setError("Password too weak");
            Snackbar snackbar = Snackbar
                    .make(coordinatorLayout, "any letter"+"\n"+"at least 1 special character,no white spaces,at least 4 characters", Snackbar.LENGTH_LONG);
            View sbView = snackbar.getView();
            TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(Color.YELLOW);
            snackbar.show();

            return false;
        } else {
            etPassword.setError(null);
            return true;
        }
    }

    private void getLoginUser() {
        presenter = new LoginPresenterImpl(this, new GetLoginIntractorImpl(etUser.getText().toString().trim(), etPassword.getText().toString().trim(), 1));
        presenter.validateLoginInFromServer();
    }
}
