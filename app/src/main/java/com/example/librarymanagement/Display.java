package com.example.librarymanagement;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Display extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        AlertDialog.Builder dialogBuilder;
        AlertDialog dialog;


        super.onCreate(savedInstanceState);


        dialogBuilder = new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.activity_display,null);

        TextView RS = findViewById(R.id.RStatus);
        TextView Reservered = findViewById(R.id.REMailid);




    }
}