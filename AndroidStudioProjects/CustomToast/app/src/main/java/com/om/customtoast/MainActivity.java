package com.om.customtoast;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater inflater=getLayoutInflater();
                View myView=inflater.inflate(R.layout.custom_toast,(ViewGroup) findViewById(R.id.toast_root));
                TextView tvMsg=myView.findViewById(R.id.textView);
                tvMsg.setText("Message For You:You got a mail ");
                Toast mytoast=new Toast(MainActivity.this);
                mytoast.setView(myView);
                mytoast.setDuration(Toast.LENGTH_LONG);
                mytoast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                mytoast.show();







            }
        });

    }
}