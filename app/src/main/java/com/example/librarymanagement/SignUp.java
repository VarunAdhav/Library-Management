package com.example.librarymanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private Button SignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        mAuth = FirebaseAuth.getInstance();

        TextView Login = findViewById(R.id.Sign);
        EditText Email = findViewById(R.id.EmailId);
        EditText Password = findViewById(R.id.Password);
        SignUp = findViewById(R.id.Log);


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Log = new Intent(SignUp.this,LogIn.class);
                startActivity(Log);

            }
        });

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Email.getText().toString().isEmpty() || Password.getText().toString().isEmpty()){
                    Toast.makeText(SignUp.this, "Email or Password should not be empty!!", Toast.LENGTH_SHORT).show();
                    return;
                }
                mAuth.createUserWithEmailAndPassword(Email.getText().toString().trim() ,Password.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(SignUp.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                                }else {
                                    Toast.makeText(SignUp.this, "Registration Failed!!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}