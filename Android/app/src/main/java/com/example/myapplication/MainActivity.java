package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.util.Log;

import android.widget.Button;

import android.content.Intent;

import android.app.Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openContinuePractice(View v) {
        Intent i = new Intent(this, ContinuePractice.class);
        startActivity(i);
    }
}