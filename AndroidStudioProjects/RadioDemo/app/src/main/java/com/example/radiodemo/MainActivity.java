package com.example.radiodemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton male,female;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        male=findViewById(R.id.male);
        female=findViewById(R.id.female);

    }
    public void show(View v)
    {
        if(male.isChecked())
        {
            Toast.makeText(this,"You Are Selected Male",Toast.LENGTH_LONG).show();
        }
        if(female.isChecked())
        {
            Toast.makeText(this,"You Are Selected Femail",Toast.LENGTH_LONG).show();
        }
    }
}