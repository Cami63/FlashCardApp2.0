package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.util.Log;

import android.widget.Button;

import android.content.Intent;

import android.app.Activity;

public class SearchPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_page);
    }
    public void searching (View search) {
        Intent i = new Intent(this, SearchResults.class);
        startActivity(i);
    }
}