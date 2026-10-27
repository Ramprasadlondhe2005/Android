package com.example.abslogindemo;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    EditText etName,etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etPass = findViewById(R.id.etPass);
    }

        public void Login(View v)
        {
            String strname=etName.getText().toString();
            String strpass=etPass.getText().toString();

            if(strname.equals("Om") && strpass.equals("om@123"))
            {
                Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "Login Faied", Toast.LENGTH_SHORT).show();
            }

        }

    }
