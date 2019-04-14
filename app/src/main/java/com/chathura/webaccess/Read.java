package com.chathura.webaccess;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class Read extends AppCompatActivity {
    protected TextView textView  = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        textView = findViewById(R.id.textView);
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://192.168.8.101:8080/demo/all";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new HTTPResponseListner(), new HTTPErrorListner());
        queue.add(stringRequest);
    }

    class HTTPResponseListner implements Response.Listener<String>{
        @Override
        public void onResponse(String response) {
            textView.setText("Response is: "+ response);
        }
    }

    class HTTPErrorListner implements Response.ErrorListener {
        @Override
        public void onErrorResponse(VolleyError error) {
            textView.setText("That didn't work!");
        }
    }
}
