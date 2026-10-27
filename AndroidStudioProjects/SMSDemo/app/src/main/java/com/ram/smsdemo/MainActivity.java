package com.ram.smsdemo;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
   EditText txtMb,txtMsg;
   Button btnSend;
    @Override
    protected void onCreate(Bundle b)
    {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        txtMb = findViewById(R.id.txtMb);
        txtMsg = findViewById(R.id.txtMsg);
        btnSend = findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try
                {
                    SmsManager smgr = SmsManager.getDefault();
                    smgr.sendTextMessage(txtMb.getText().toString(),null, txtMsg.getText().toString(),null,null);
                    Toast.makeText(MainActivity.this, "SMS Sent Successfully", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e)
                {
                    Toast.makeText(MainActivity.this, "SMS Failed to Send, Please try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
