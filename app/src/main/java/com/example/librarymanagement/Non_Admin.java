package com.example.librarymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Non_Admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_non_admin);

        Button search = findViewById(R.id.Search_Book);
        Button reserve = findViewById(R.id.Reserve_Books);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent find = new Intent(Non_Admin.this,Search_Books.class);
                startActivity(find);        //find == search
            }
        });
        reserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Reserve  = new Intent(Non_Admin.this, com.example.librarymanagement.Reserve.class);
                startActivity(Reserve);
            }
        });
    }
}