package com.example.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText num1,num2;
    Button btn,btn2,btn3,btn4;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1=findViewById(R.id.num1);
        num2=findViewById(R.id.num2);
        btn=findViewById(R.id.btn);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);

    }
    public void Add(View view)
    {
        if(num1.getText().toString().equals("")){
            num1.setError("Please Enter NUmber");
            num1.requestFocus();
            return;
        }
        if(num2.getText().toString().equals("")){
            num2.setError("Please Enter Number");
            num2.requestFocus();
            return;
        }
        Double number1= Double.parseDouble(num1.getText().toString());
        Double number2= Double.parseDouble(num2.getText().toString());
        Double result=number1+number2;
        Toast.makeText(MainActivity.this, "Addition= "+result, Toast.LENGTH_SHORT).show();

    }
    public void Sub(View view)
    {
        if(num1.getText().toString().equals("")){
            num1.setError("Please Enter NUmber");
            num1.requestFocus();
            return;
        }
        if(num2.getText().toString().equals("")){
            num2.setError("Please Enter Number");
            num2.requestFocus();
            return;
        }
        Double number1= Double.parseDouble(num1.getText().toString());
        Double number2= Double.parseDouble(num2.getText().toString());
        Double result=number1-number2;
        Toast.makeText(MainActivity.this, "Substraction= "+result, Toast.LENGTH_SHORT).show();

    }
    public void Mul(View view)
    {
        if(num1.getText().toString().equals("")){
            num1.setError("Please Enter NUmber");
            num1.requestFocus();
            return;
        }
        if(num2.getText().toString().equals("")){
            num2.setError("Please Enter Number");
            num2.requestFocus();
            return;
        }
        Double number1= Double.parseDouble(num1.getText().toString());
        Double number2= Double.parseDouble(num2.getText().toString());
        Double result=number1*number2;
        Toast.makeText(MainActivity.this, "Muliplication= "+result, Toast.LENGTH_SHORT).show();

    }
    public void Div(View view)
    {
        if(num1.getText().toString().equals("")){
            num1.setError("Please Enter NUmber");
            num1.requestFocus();
            return;
        }
        if(num2.getText().toString().equals("")){
            num2.setError("Please Enter Number");
            num2.requestFocus();
            return;
        }
        Double number1= Double.parseDouble(num1.getText().toString());
        Double number2= Double.parseDouble(num2.getText().toString());
        Double result=number1/number2;
        Toast.makeText(MainActivity.this, "Division= "+result, Toast.LENGTH_SHORT).show();

    }
}