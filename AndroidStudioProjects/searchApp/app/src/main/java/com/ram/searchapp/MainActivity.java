package com.ram.searchapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity
{

    AutoCompleteTextView srEngine;
    @Override
    protected void onCreate(Bundle b)
    {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        srEngine=findViewById(R.id.srEngine);

        String strArr[]={"MAD","NIS","PWP","ETI","MGT","EDE","CMS"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,strArr);
        srEngine.setAdapter(adapter);
        srEngine.setThreshold(1);

    }
}








