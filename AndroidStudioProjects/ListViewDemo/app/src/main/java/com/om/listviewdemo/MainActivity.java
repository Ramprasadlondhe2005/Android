package com.om.listviewdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);
        String strArr[] = {"Android", "Java", "Php", "Sap", "C++", "Ruby", "C Programming", "Python", "Kotlin", "Bootstrap"};

     /*   ArrayList<String> strArr=new ArrayList<String>();
        strArr.add("Android");
        strArr.add("Java");
        strArr.add("Php");
        strArr.add("SAP");
        strArr.add("C++");
        strArr.add("Ruby");*/

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, strArr);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String strItem=adapter.getItem(position);
                Toast.makeText(MainActivity.this,strItem,Toast.LENGTH_LONG).show();
            }
        });

    }
}