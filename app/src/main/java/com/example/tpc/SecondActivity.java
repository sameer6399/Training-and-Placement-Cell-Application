package com.example.tpc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SecondActivity extends AppCompatActivity {

    EditText etRegisterUserName, etRegisterPassword;
    Button btnSignUp, btnBack;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //etRegisterPassword = findViewById(R.id.etRegisterPassword);
        etRegisterUserName = findViewById(R.id.etRegisterUserName);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnBack = findViewById(R.id.btnBack);
        firebaseAuth = FirebaseAuth.getInstance();

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etRegisterUserName.getText().toString();
                firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(SecondActivity.this, "Please Check Your Email", Toast.LENGTH_SHORT).show();
                            Intent a = new Intent(SecondActivity.this, MainActivity.class);
                            startActivity(a);
                        }
                        else
                        {
                            Toast.makeText(SecondActivity.this, "Issue Occoured "+task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        /*btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etRegisterUserName.getText().toString();
                String password = etRegisterPassword.getText().toString();
                firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            Intent c = new Intent(SecondActivity.this, ThirdActivity.class);
                            startActivity(c);
                            finish();
                        }
                        else
                        {
                            Toast.makeText(SecondActivity.this, "Invalid Details ", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });*/

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(b);
                finish();
            }
        });
    }
}
