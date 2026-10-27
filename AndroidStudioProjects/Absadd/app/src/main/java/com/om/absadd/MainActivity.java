package com.om.absadd;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);


    }
    public void add(View view)
    {
        int num1=Integer.parseInt(et1.getText().toString());
        int num2=Integer.parseInt(et2.getText().toString());

        int c=num1+num2;
        Toast.makeText(MainActivity.this, "Addition"+c, Toast.LENGTH_LONG).show();
    }
}