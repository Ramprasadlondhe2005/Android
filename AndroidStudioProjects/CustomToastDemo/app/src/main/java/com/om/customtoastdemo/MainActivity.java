package com.om.customtoastdemo;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

public class MainActivity extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater inflater=getLayoutInflater();
                View myView=inflater.inflate(R.layout.custom_toast,(ViewGroup) findViewById(R.id.toast_root));


                TextView tvMsg=myView.findViewById(R.id.toast_text);
                tvMsg.setText("Message For You:You have got a mail");
                Toast oToast=new Toast(MainActivity.this);
                oToast.setView(myView);
                oToast.setDuration(Toast.LENGTH_LONG);

                oToast.show();
            }
        });
    }
}