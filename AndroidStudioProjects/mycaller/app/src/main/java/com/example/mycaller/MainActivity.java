package com.example.mycaller;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText etxtNum;
    Button btnCall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etxtNum=findViewById(R.id.etxtNum);
        btnCall=findViewById(R.id.btnCall);

    }
    public void call(View view)
    {
        String MobileNumber=etxtNum.getText().toString();

        if(MobileNumber.equals("")){
            etxtNum.setError("Please Enter NUmber");
            etxtNum.requestFocus();
            return;
        }
        if(MobileNumber.length()!=10){
            etxtNum.setError("Please Enter NUmber");
            etxtNum.requestFocus();
            return;
        }
        Intent oI=new Intent(Intent.ACTION_CALL);
        oI.setData(Uri.parse("tel:"+MobileNumber));
        startActivity(oI);
    }
}