package com.example.checkboxdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    CheckBox cb1,cb2,cb3,cb4;
    Button btn;
    String strMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        cb1=findViewById(R.id.cb1);
        cb2=findViewById(R.id.cb2);
        cb3=findViewById(R.id.cb3);;
        cb4=findViewById(R.id.cb4);
        btn=findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(cb1.isChecked()){
                    strMsg="\nYou selected java";
                }
                if(cb2.isChecked()){
                    strMsg="\nHTML";
                }
                if(cb3.isChecked()){
                    strMsg="\npython";
                }
                if(cb4.isChecked()){
                    strMsg="\njs";
                }
                Toast.makeText(MainActivity.this, "You selected"+strMsg, Toast.LENGTH_LONG).show();
            }
        });



    }
}