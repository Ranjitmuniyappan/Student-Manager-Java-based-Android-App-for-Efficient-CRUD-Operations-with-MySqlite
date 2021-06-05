package com.rsa.spider.Home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.rsa.spider.AddStudent.NewStudent;
import com.rsa.spider.MapView.MapMaster;
import com.rsa.spider.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


    }

    public void addStudent(View view)
    {
        Intent i = new Intent(HomeActivity.this, NewStudent.class);
        startActivity(i);
    }

    public void mapView(View view)
    {
        Intent i = new Intent(HomeActivity.this, MapMaster.class);
        startActivity(i);
    }
}