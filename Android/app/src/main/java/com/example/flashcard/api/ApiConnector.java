package com.example.flashcard.api;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class ApiConnector {
    public static void getSets(Context ctx, Response.Listener<String> listener){
        RequestQueue queue = Volley.newRequestQueue(ctx);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://10.0.2.2:5000/sets", listener, error -> {
            Log.e("ApiConnector", error.getMessage());
        });

        queue.add(stringRequest);
    }
}
