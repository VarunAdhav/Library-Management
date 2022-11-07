package com.example.librarymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodSubtype;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Locale;

public class Add_Book extends AppCompatActivity {

    FirebaseDatabase RootNode;
    DatabaseReference Reference;
    final Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        Button add = findViewById(R.id.CreateBr);
        EditText BooksName = findViewById(R.id.BookName);
        EditText ISBN = findViewById(R.id.ISBN);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(BooksName.getText().toString().isEmpty() || ISBN.getText().toString().isEmpty()){
                    Toast.makeText(Add_Book.this, "Please Confirm that nothing is Empty", Toast.LENGTH_SHORT).show();
                }else {
                    RootNode = FirebaseDatabase.getInstance();
                    Reference = RootNode.getReference("Books");

                    String Book = BooksName.getText().toString().toLowerCase(Locale.ROOT);
                    String isbn = ISBN.getText().toString().toLowerCase(Locale.ROOT);
                    String avail = "Yes";
                    String R_Status = null;

                    helperclass book = new helperclass(Book,isbn,avail,R_Status);

                    Reference.child(isbn).setValue(book);


                    Intent back = new Intent(Add_Book.this,admin.class);
                    startActivity(back);


                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(Add_Book.this, "Successfully Added A New Book", Toast.LENGTH_SHORT).show();

                        }
                    },500);
                }
            }
        });
    }

}