package com.example.tpc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class fourthActivity extends AppCompatActivity {

    Button btnExit, btnBack2;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        btnExit = findViewById(R.id.btnExit);
        btnBack2 = findViewById(R.id.btnBack2);
        firebaseAuth = FirebaseAuth.getInstance();

        btnBack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(fourthActivity.this, ThirdActivity.class);
                startActivity(b);
                finish();
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                Intent a = new Intent(fourthActivity.this, MainActivity.class);
                startActivity(a);
                finish();
            }
        });

        Spinner spinner = findViewById(R.id.spinner);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Below 6.5");
        arrayList.add("6.5 to 7");
        arrayList.add("7 to 7.5");
        arrayList.add("7.5 to 8");
        arrayList.add("8 Above");
        arrayList.add("ALL");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        Spinner spinner2 = findViewById(R.id.spinner2);
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("COMPUTER ENGINEERING");
        arrayList2.add("INFORMATION TECHNOLOGY");
        arrayList2.add("ELECTRONICS AND TELECOMMUNICATION");
        arrayList2.add("ELECTRONICS");
        arrayList2.add("INSTRUMENTATION");
        arrayList2.add("ALL BRANCHES");
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arrayList2);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(arrayAdapter2);

        Spinner spinner3 = findViewById(R.id.spinner3);
        ArrayList<String> arrayList3 = new ArrayList<>();
        arrayList3.add("0");
        arrayList3.add("1");
        arrayList3.add("2");
        arrayList3.add("3");
        arrayList3.add("ALL");
        ArrayAdapter<String> arrayAdapter3 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arrayList3);
        arrayAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(arrayAdapter3);
    }
}
