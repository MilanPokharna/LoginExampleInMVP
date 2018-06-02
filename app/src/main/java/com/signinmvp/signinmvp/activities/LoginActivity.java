package com.signinmvp.signinmvp.activities;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.signinmvp.signinmvp.R;
import com.signinmvp.signinmvp.model.presenterImpl;
import com.signinmvp.signinmvp.presenter.LoginPresenter;
import com.signinmvp.signinmvp.view.LoginView;

public class LoginActivity extends Activity implements View.OnClickListener,LoginView
{

    TextView tvLogin;
    EditText etUsername;
    EditText etPassword;
    LoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tvLogin = findViewById(R.id.tvlogin);
        etUsername = findViewById(R.id.etusername);
        etPassword = findViewById(R.id.etpassword);
        loginPresenter = new presenterImpl(this);
        tvLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();
        loginPresenter.performLogin(username,password);
    }

    @Override
    public void loginValidations() {
        Toast.makeText(getApplicationContext(), "Please enter username and password", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(getApplicationContext(),"Logged in Successfully",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginError() {
        Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_SHORT).show();
    }
}
