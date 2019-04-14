package com.chathura.webaccess;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void readAction(View view) {
        Intent intent = new Intent(this, Read.class);
        startActivity(intent);
    }

    protected void createAction(View view) {
        Intent intent = new Intent(this, CreateActivity.class);
        startActivity(intent);
    }
}
