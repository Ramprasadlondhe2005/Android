package com.example.loginwindow;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            et1=findViewById(R.id.et1);
            et2=findViewById(R.id.et2);
            btn=findViewById(R.id.btn);

    }
    public void Submit(View v)
    {
        String email=et1.getText().toString();
        String Password=et2.getText().toString();

        if(email.equals("xyz@gmail.com") && Password.equals("Ram@123"))
        {
            Toast.makeText(MainActivity.this, "Login Successfully...!!!", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(MainActivity.this, "Login Failed...!!", Toast.LENGTH_LONG).show();
        }
    }
}