package com.example.relativecalc;

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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText et1,et2;
    Button btnAdd,btnSub,btnMul,btnDiv;
    int num1,num2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        btnAdd=findViewById(R.id.btnAdd);
        btnSub=findViewById(R.id.btnSub);
        btnMul=findViewById(R.id.btnMul);
        btnDiv=findViewById(R.id.btnDiv);

        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        num1=Integer.parseInt(et1.getText().toString());
        num2=Integer.parseInt(et2.getText().toString());
        if(v==btnAdd)
        {
            int res=num1+num2;
            Toast.makeText(this, "Addition"+res, Toast.LENGTH_SHORT).show();
        }
        else if(v==btnSub)
        {
            int res=num1-num2;
            Toast.makeText(this, "SubStraction"+res, Toast.LENGTH_SHORT).show();
        }
        else if(v==btnMul)
        {
            int res=num1*num2;
            Toast.makeText(this, "Multiplication"+res, Toast.LENGTH_SHORT).show();
        }
        else if(v==btnDiv)
        {
            int res=num1/num2;
            Toast.makeText(this, "Division"+res, Toast.LENGTH_SHORT).show();
        }
    }
}