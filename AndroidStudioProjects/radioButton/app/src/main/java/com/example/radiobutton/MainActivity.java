package com.example.radiobutton;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    RadioButton rb1,rb2;
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        rb1=findViewById(R.id.rb1);
        rb2=findViewById(R.id.rb2);
    }
    public void onclick(View v)
    {
        if(rb1.isChecked())
        {
            Toast.makeText(this, "You Select Male", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "You Select Female", Toast.LENGTH_SHORT).show();
        }
    }
}