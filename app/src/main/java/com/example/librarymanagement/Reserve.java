package com.example.librarymanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Reserve extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve);

        Button Reserve = findViewById(R.id.Reserve);
        EditText Name = findViewById(R.id.BName);

        Reserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Name.getText().toString().isEmpty()){
                    Toast.makeText(Reserve.this, "Don't Leave anything Empty", Toast.LENGTH_SHORT).show();
                }else {
                    String BookName = Name.getText().toString();
                    DatabaseReference Reference = FirebaseDatabase.getInstance().getReference("Books");
                    Query search = Reference.orderByChild("bookName").equalTo(BookName);

                    search.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.exists()){
                                /*String Avail = (String) snapshot.child("availability").child("availability").getValue();
                                Book_Name.setText(BookName);
                                avail.setText("Availability Status: "+Avail);*/

                                Toast.makeText(Reserve.this, "Book Found and Reserved", Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(Reserve.this, "No Such Book Found", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });
    }
}