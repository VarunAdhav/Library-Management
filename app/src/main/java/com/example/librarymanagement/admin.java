package com.example.librarymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class admin extends AppCompatActivity {

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        Button SBooks = findViewById(R.id.CreateBr);
        Button CBooks = findViewById(R.id.Create);

        getSupportActionBar().setTitle("Admin");


        SBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SearchBooks = new Intent(admin.this,Search_Books.class);
                startActivity(SearchBooks);
            }
        });
        CBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AddBooks = new Intent(admin.this,Add_Book.class);
                startActivity(AddBooks);
            }
        });
    }
}