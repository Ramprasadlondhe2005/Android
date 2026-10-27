package com.ram.calciapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    EditText et1;
    int iOperator=0;
    double dVal1=0,dVal2=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=findViewById(R.id.et1);
    }
    public void textDisplay(View v)
    {
        if(v.getId()==R.id.btn0)
        {
            setNumber(0);
        }
        else if(v.getId()==R.id.btn1)
        {
           setNumber(1);
        }
        else if(v.getId()==R.id.btn2)
        {
             setNumber(2);
        }
        else if(v.getId()==R.id.btn3)
        {
            setNumber(3);
        }
        else if(v.getId()==R.id.btn4)
        {
            setNumber(4);
        }
        else if(v.getId()==R.id.btn5)
        {
            setNumber(5);
        }
        else if(v.getId()==R.id.btn6)
        {
            setNumber(6);
        }
        else if(v.getId()==R.id.btn7)
        {
            setNumber(7);
        }
        else if(v.getId()==R.id.btn8)
        {
            setNumber(8);
        }
        else if(v.getId()==R.id.btn9)
        {
            setNumber(9);
        }

    }
    public void setNumber(int iNum)
    {
        double dVal = Double.parseDouble(et1.getText().toString());
        if(dVal>0)
        {

            et1.append(""+iNum);
        }
        else
        {
            et1.setText(""+iNum);
        }
    }
    public void simpleCalci(View v)
    {
        if (v.getId() == R.id.btnClear)
        {
            iOperator = 1;
            et1.setText("0");
        }
        else if (v.getId() == R.id.btnAdd)
        {
            iOperator = 2;
            dVal1 = Double.parseDouble(et1.getText().toString());
            et1.setText("0");
        }
        else if (v.getId() == R.id.btnSub)
        {
            iOperator = 3;
            dVal1 = Double.parseDouble(et1.getText().toString());
            et1.setText("0");
        }

        else if (v.getId() == R.id.btnDiv)
        {
            iOperator = 4;
            dVal1 = Double.parseDouble(et1.getText().toString());
            et1.setText("0");
        }
        else if (v.getId() == R.id.btnEq)
        {
            double iResult = 0;
            dVal2 = Double.parseDouble(et1.getText().toString());

            switch (iOperator)
            {
                case 1:
                    iResult = dVal1 + dVal2;
                    break;

                case 2:
                    iResult = dVal1 - dVal2;
                    break;

                case 3:
                    iResult = dVal1 * dVal2;
                    break;

                case 4:
                    iResult = dVal1 / dVal2;
                    break;
            }
            et1.setText("" + iResult);
        }
    }
}