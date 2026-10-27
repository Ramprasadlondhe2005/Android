package com.example.checkbox;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    CheckBox cb1,cb2,cb3,cb4;
    Button btn;
    String strMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cb1=findViewById(R.id.cb1);
        cb2=findViewById(R.id.cb2);
        cb3=findViewById(R.id.cb3);;
        cb4=findViewById(R.id.cb4);
        btn=findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                strMsg=" ";
                if(cb1.isChecked())
                {
                    strMsg+="Coffee";
                }
                if(cb2.isChecked())
                {
                    strMsg+="\nVadapav";
                }
                if(cb3.isChecked())
                {
                    strMsg+="\nPizza";
                }
                if(cb4.isChecked())
                {
                    strMsg+="\nBurger";
                }
                Toast.makeText(MainActivity.this, "You selected"+strMsg, Toast.LENGTH_LONG).show();
                //Snackbar.make(v,"You selected"+strMsg, Toast.LENGTH_LONG).show();
            }
        });



    }
}