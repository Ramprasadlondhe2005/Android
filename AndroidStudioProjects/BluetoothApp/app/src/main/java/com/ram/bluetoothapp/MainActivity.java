package com.ram.bluetoothapp;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnOn,btnVis,btnList,btnOff;
    BluetoothAdapter oBA;
    ListView lv;
    Set<BluetoothDevice> pairedDevices;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOn=findViewById(R.id.btnOn);
        btnVis=findViewById(R.id.btnVis);
        btnList=findViewById(R.id.btnList);
        btnOff=findViewById(R.id.btnOff);
        btnOn.setOnClickListener(this);
        btnVis.setOnClickListener(this);
        btnList.setOnClickListener(this);
        btnOff.setOnClickListener(this);
        lv=findViewById(R.id.lv);

        oBA=BluetoothAdapter.getDefaultAdapter();

    }

    @SuppressLint("MissingPermission")
    @Override
    public void onClick(View v)
    {
        if(v==btnOn)
        {
            if(!oBA.isEnabled())
            {
                Intent oI = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(oI, 0);

                Toast.makeText(getApplicationContext(), "Bluetooth is Turned on",Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Bluetooth is already on", Toast.LENGTH_LONG).show();
            }
        }
        else if(v==btnOff)
        {
                 oBA.disable();
                 Toast.makeText(getApplicationContext(), "Bluetooth is off", Toast.LENGTH_LONG).show();
        }
        else if(v==btnVis)
        {
            Intent oI= new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
            startActivityForResult(oI, 0);

        }
        else if (v==btnList)
        {
            pairedDevices = oBA.getBondedDevices();
            ArrayList list = new ArrayList();
            for(BluetoothDevice bt : pairedDevices) list.add(bt.getName());
            Toast.makeText(getApplicationContext(),"Showing Paired Devices",Toast.LENGTH_SHORT).show();
            final ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, list);
            lv.setAdapter(adapter);

        }

    }
}