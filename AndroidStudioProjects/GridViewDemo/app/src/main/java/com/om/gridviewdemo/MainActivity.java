package com.om.gridviewdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    GridView gvButtons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gvButtons= findViewById(R.id.gridview);
        String strArr[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,R.layout.buttonlayout,R.id.button,strArr);
        gvButtons.setAdapter(adapter);
        gvButtons.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Button btnTemp=(Button)view;
                Toast.makeText(MainActivity.this,""+btnTemp.getText(),Toast.LENGTH_LONG).show();
            }
        });
    }
}