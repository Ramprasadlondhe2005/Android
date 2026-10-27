package com.example.layoutdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText etname,etage,etmob;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etname=findViewById(R.id.etname);
        etage=findViewById(R.id.etage);
        etmob=findViewById(R.id.etmob);
        btn=findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                String strname=etname.getText().toString();
                String age=etage.getText().toString();
                String mob=etmob.getText().toString();



                Toast.makeText(MainActivity.this, "Name="+strname+"\nAge="+age+"\nMob="+mob, Toast.LENGTH_SHORT).show();
            }


        });
    }
}