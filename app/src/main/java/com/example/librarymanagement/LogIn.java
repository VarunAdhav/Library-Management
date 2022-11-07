package com.example.librarymanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SignalThresholdInfo;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LogIn extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private String admin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

    mAuth = FirebaseAuth.getInstance();

    Button LogIn = findViewById(R.id.Log);
    EditText Password = findViewById(R.id.Password);
    EditText Email = findViewById(R.id.EmailId);
    TextView SignUp = findViewById(R.id.Sign);
    admin = "admin@gmail.com";

    SignUp.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent SignUp = new Intent(LogIn.this,SignUp.class);
            startActivity(SignUp);
        }
    });

    LogIn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
                if(Email.getText().toString().isEmpty() || Password.getText().toString().isEmpty()){
                    Toast.makeText(LogIn.this, "Email Id or Password can't be empty", Toast.LENGTH_SHORT).show();
                }
                mAuth.signInWithEmailAndPassword(Email.getText().toString().trim() , Password.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful() && Email.getText().toString().trim().equals(admin) ){
                                    Intent Admin = new Intent(LogIn.this,admin.class);
                                    startActivity(Admin);
                                    Toast.makeText(LogIn.this, "Successfully Logged In as Admin", Toast.LENGTH_SHORT).show();

                                }else if (task.isSuccessful()){
                                    Intent nonAdmin = new Intent(com.example.librarymanagement.LogIn.this,Non_Admin.class);
                                    startActivity(nonAdmin);
                                    Toast.makeText(LogIn.this, "Successfully Logged In", Toast.LENGTH_SHORT).show();
                                }else {
                                    Toast.makeText(LogIn.this, "Something Went Wrong!!", Toast.LENGTH_SHORT).show();
                                    Toast.makeText(LogIn.this, "Try Again", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
        }
    });

    }
}