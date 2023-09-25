package com.example.tpc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnRegister, btnLogin;
    EditText etUserName, etPassword;
    FirebaseAuth firebaseAuth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPassword = findViewById(R.id.etPassword);
        etUserName = findViewById(R.id.etUserName);
        btnLogin = findViewById(R.id.btnLogIn);
        btnRegister = findViewById(R.id.btnRegister);
        firebaseAuth = FirebaseAuth.getInstance();

        user = firebaseAuth.getCurrentUser();

        if (user != null) {
            Intent a = new Intent(MainActivity.this, ThirdActivity.class);
            startActivity(a);
            finish();
        }

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(a);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etUserName.getText().toString();
                String password = etPassword.getText().toString();
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent a = new Intent(MainActivity.this, ThirdActivity.class);
                            startActivity(a);
                            finish();
                        } else {
                            Toast.makeText(MainActivity.this, "Invalid Details" , Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}