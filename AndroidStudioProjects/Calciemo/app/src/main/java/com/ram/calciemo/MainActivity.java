package com.ram.calciemo;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    EditText e1, e2;
    Button add, sub, mul, div;
    int num1, num2;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.num1);
        e2 = findViewById(R.id.num2);

        add = findViewById(R.id.sum);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);
        sub = findViewById(R.id.sub);

        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        num1 = Integer.parseInt(e1.getText().toString());
        num2 = Integer.parseInt(e2.getText().toString());
        if(v==add)
        {
            int c=num1+num2;
            Toast.makeText(this, "Addition"+c, Toast.LENGTH_SHORT).show();
        }
        if(v==sub)
        {
            int c=num1-num2;
            Toast.makeText(this, "Substraction"+c, Toast.LENGTH_SHORT).show();
        }
        if(v==mul)
        {
            int c=num1*num2;
            Toast.makeText(this, "Multiplication"+c, Toast.LENGTH_SHORT).show();
        }
        if(v==div)
        {
            int c=num1+num2;
            Toast.makeText(this, "Division"+c, Toast.LENGTH_SHORT).show();
        }
    }
}
