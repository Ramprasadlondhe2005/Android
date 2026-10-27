package com.example.factdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etFact;
    Button btn;


    @Override
    protected void onCreate(Bundle b)
    {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        etFact = findViewById(R.id.etFact);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int num = Integer.parseInt(etFact.getText().toString());
                int fact= 1;
                for (int i = 1; i <= num; i++)
                {
                    fact=fact*i;
                }
                Toast.makeText(MainActivity.this, "Factorial:"+fact, Toast.LENGTH_LONG).show();
            }
        });
    }
}