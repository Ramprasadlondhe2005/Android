package com.example.studentdata;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etAge, etMno, etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        etMno = findViewById(R.id.etMNo);
    }

    public void Data(View v)
    {
        String nm = etName.getText().toString();
        int age = Integer.parseInt(etAge.getText().toString());
        int mb = Integer.parseInt(etMno.getText().toString());

        // Corrected concatenation
        String strMsg = "Name: " + nm + "\nAge: " + age + "\nMobile Number: " + mb;

        Toast.makeText(MainActivity.this, strMsg, Toast.LENGTH_LONG).show();
    }
}
