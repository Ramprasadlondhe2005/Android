package com.example.registrationsystem;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2,et3,et4,et5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        et3=findViewById(R.id.et3);
        et4=findViewById(R.id.et4);
        et5=findViewById(R.id.et5);
    }
    public void register(View v)
    {
        String strName=et1.getText().toString();
        String strRollno=et2.getText().toString();
        String strClass=et3.getText().toString();
        String strEmail=et4.getText().toString();
        String strContact=et5.getText().toString();


            Toast.makeText(this, "Name="+strName+"RollNo="+strRollno+"Class="+strClass+"Email="+strEmail+"Contact="+strContact,Toast.LENGTH_LONG).show();

    }
}