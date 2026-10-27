package com.om.layout;

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

public class MainActivity extends AppCompatActivity
{
    EditText eTNum1,eTNum2;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        eTNum1=findViewById(R.id.eTNumber1);
        eTNum2=findViewById(R.id.eTNumber2);
        btn=findViewById(R.id.button);
    }
    public void onClick(View v)
    {
        int iNum1=Integer.parseInt(eTNum1.getText().toString());
        int iNum2=Integer.parseInt(eTNum2.getText().toString());
        int c=iNum1+iNum2;
        Toast.makeText(MainActivity.this, "Addition="+c, Toast.LENGTH_SHORT).show();
    }
}