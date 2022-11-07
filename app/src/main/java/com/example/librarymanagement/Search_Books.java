package com.example.librarymanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.sql.Ref;
import java.util.Locale;

public class Search_Books extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_books);

        EditText Name = findViewById(R.id.SBook);
        Button Search = findViewById(R.id.SearchB);
        TextView Book_Name = findViewById(R.id.BN);
        TextView avail = findViewById(R.id.availability);

        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Name.getText().toString().isEmpty()){
                    Toast.makeText(Search_Books.this, "Don't Leave anything Empty", Toast.LENGTH_SHORT).show();
                }else {
                    String BookName = Name.getText().toString().toLowerCase(Locale.ROOT);
                    DatabaseReference Reference = FirebaseDatabase.getInstance().getReference("Books");
                    Query search = Reference.orderByChild("bookName").equalTo(BookName);

                    /*Reference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.exists()){

                                String Value = snapshot.getValue(String.class);
                                avail.setText(Value);
                                Toast.makeText(Search_Books.this, "Book Found...", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(Search_Books.this, "No Such Book Found", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(Search_Books.this, "", Toast.LENGTH_SHORT).show();
                        }
                    });*/

                    search.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.exists()){
                                //String Avail = (String) snapshot.child().getValue();
                                String bkn = (String) snapshot.child("book ").getKey();
                                // Book_Name.setText(BookName);
                                avail.setText("Availability Status: ");
                                Toast.makeText(Search_Books.this, "Book Found!!", Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(Search_Books.this, "No Such Book Found", Toast.LENGTH_SHORT).show();
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