package com.example.tpc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends AppCompatActivity {

    Button btnLogout, btnList;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        btnList = findViewById(R.id.btnList);
        btnLogout = findViewById(R.id.btnLogout);
        firebaseAuth = FirebaseAuth.getInstance();


        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                Intent a = new Intent(ThirdActivity.this, MainActivity.class);
                startActivity(a);
                finish();
            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(ThirdActivity.this, fourthActivity.class);
                startActivity(b);
                finish();
            }
        });
    }
}
