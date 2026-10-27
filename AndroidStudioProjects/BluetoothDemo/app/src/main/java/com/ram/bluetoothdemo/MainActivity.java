package com.ram.bluetoothdemo;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnOn, btnOff;
    BluetoothAdapter oBA;

    @Override
    protected void onCreate(Bundle b)
    {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        btnOn = findViewById(R.id.btnOn);
        btnOff = findViewById(R.id.btnOff);

        btnOn.setOnClickListener(this);
        btnOff.setOnClickListener(this);

        oBA = BluetoothAdapter.getDefaultAdapter();
    }

    @Override
    public void onClick(View v)
    {
        if (v == btnOn)
        {
            if (!oBA.isEnabled())
            {
                Intent oI = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(oI, 0);
                Toast.makeText(getApplicationContext(), "Bluetooth is on", Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Bluetooth is already on", Toast.LENGTH_LONG).show();
            }
        }
        else if (v == btnOff) {
            if (oBA.disable())
            {

                Toast.makeText(getApplicationContext(), "Bluetooth is off", Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Bluetooth is already off", Toast.LENGTH_LONG).show();
            }
        }
    }
}
