package com.rsa.spider.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.rsa.spider.Home.HomeActivity;
import com.rsa.spider.R;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login3);
    }

    public void putLogin(View view)
    {
        Intent i = new Intent(Login.this, HomeActivity.class);
        startActivity(i);
    }

    public void putRegister(View view)
    {
        Intent i = new Intent(Login.this, Register.class);
        startActivity(i);
    }
}