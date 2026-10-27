package com.example.buttonsdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String a=null;
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnsubmit,btnclear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnsubmit = findViewById(R.id.btnsubmit);
        btnclear = findViewById(R.id.btnClear);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnclear.setOnClickListener(this);
        btnsubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if(v==btn0)
        {
            a=btn0.getText().toString();

        }
        else if(v==btn1)
        {
            a=btn1.getText().toString();

        }
        else if(v==btn2)
        {
            a=btn2.getText().toString();

        }
        else if(v==btn3)
        {
            a=btn3.getText().toString();

        }
        else if(v==btn4)
        {
            a=btn4.getText().toString();
        }
        else if(v==btn5)
        {
            a=btn5.getText().toString();
        }
        else if(v==btn6)
        {
            a=btn6.getText().toString();
        }
        else if(v==btn7)
        {
            a=btn7.getText().toString();
        }
        else if(v==btn8)
        {
            a=btn8.getText().toString();
        }
        else if(v==btn9)
        {
            a=btn9.getText().toString();
        }
        else if(v==btnsubmit)
        {
            Toast.makeText(this, a, Toast.LENGTH_SHORT).show();

        }
        else if(v==btnclear)
        {

                a=" ";
        }

    }
}