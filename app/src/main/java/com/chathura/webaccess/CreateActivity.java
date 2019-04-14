package com.chathura.webaccess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class CreateActivity extends AppCompatActivity {
    EditText nameText = null;
    EditText descriptionText = null;
    EditText priceText = null;
    TextView textView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        nameText = findViewById(R.id.name);
        descriptionText = findViewById(R.id.description);
        priceText = findViewById(R.id.price);
        textView = findViewById(R.id.result);
    }

    protected void submit(View view) {
        String name = nameText.getText().toString();
        String description = descriptionText.getText().toString();
        String price = priceText.getText().toString();
        String url = "http://192.168.8.101:8080/demo/add?name="+name+"&description="+description+"&price="+price;

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new HTTPResponseListner(), new HTTPErrorListner());
        queue.add(stringRequest);
    }

    class HTTPResponseListner implements Response.Listener<String>{
        @Override
        public void onResponse(String response) {
            textView.setText(response);
        }
    }

    class HTTPErrorListner implements Response.ErrorListener {
        @Override
        public void onErrorResponse(VolleyError error) {
            textView.setText(error.getMessage());
        }
    }
}
