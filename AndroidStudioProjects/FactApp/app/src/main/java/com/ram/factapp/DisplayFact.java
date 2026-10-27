package com.ram.factapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class DisplayFact extends AppCompatActivity {
    TextView tvNo,tvFact;
    Button btnFact;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displayfact);
        tvFact=findViewById(R.id.textView2);
        tvNo=findViewById(R.id.textView1);
        btnFact=findViewById(R.id.button2);
        Intent intent=getIntent();
        int iNo=intent.getIntExtra("Fact",0);
        tvNo.setText("Factorial of Number: "+iNo);
        int iFact=factorial(iNo);
        tvFact.setText("Factorial is "+iFact);
        btnFact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private int factorial(int iX)
    {
        if(iX ==0 || iX==1)
        {
            return 1;
        }
        else
            return (iX*factorial(iX-1));
    }
}
