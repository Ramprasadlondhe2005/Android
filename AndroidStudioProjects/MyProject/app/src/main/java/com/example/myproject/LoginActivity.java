package com.example.myproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {
EditText etxtUsername,etxtPassword;
String username="",password="";
Button btn;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etxtUsername=findViewById(R.id.etxtUsername);
        etxtPassword=findViewById(R.id.etxtPassword);
        btn=findViewById(R.id.btn);
    }
    public void btnLogin(View view)
    {
        username=etxtUsername.getText().toString();
        password=etxtPassword.getText().toString();
        if(username.equals(""))
        {
            etxtUsername.setError("Please Enter Username");
            etxtUsername.requestFocus();
            return;
        }
        if(password.equals(""))
        {
            etxtPassword.setError("Please Enter Password");
            etxtUsername.requestFocus();
            return;
        }
        if(username.equals("admin")&& password.equals("123"))
        {
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
            Toast.makeText(this, "Login Successfully..", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this, "Invalid Username and Password", Toast.LENGTH_LONG).show();
        }
    }
}