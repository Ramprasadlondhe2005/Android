package com.example.mycheckboxdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    CheckBox cb1,cb2,cb3;
    Button btnsubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        cb1=findViewById(R.id.cb1);
        cb2=findViewById(R.id.cb2);
        cb3=findViewById(R.id.cb3);
        btnsubmit=findViewById(R.id.btnsubmit);

        btnsubmit.setOnClickListener(this);

}


    @Override
    public void onClick(View v) {
        String strMsg="";
        if(cb1.isChecked())
        {
            strMsg+="\nC++";
        }
        if(cb2.isChecked())
        {
            strMsg+="\nJava";
        }
        if(cb3.isChecked())
        {
            strMsg+="\nHtml";
        }
        Toast.makeText(this, "You Selected="+strMsg, Toast.LENGTH_SHORT).show();

    }
}