package com.example.bluetoothpaireddevices;
import android.annotation.SuppressLint;
import android.bluetooth.*;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.*;


public class MainActivity extends AppCompatActivity
{
    Button btnList;
    BluetoothAdapter BA;
    Set<BluetoothDevice> pairedDevices;
    ListView lv;
    @Override

    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        btnList = findViewById(R.id.btnList);
        lv = findViewById(R.id.lv);
        BA = BluetoothAdapter.getDefaultAdapter();
    }
    @SuppressLint("MissingPermission")
    public void list(View v)
    {
        pairedDevices = BA.getBondedDevices();
        ArrayList list = new ArrayList();
        for(BluetoothDevice bt : pairedDevices)
        {
            list.add(bt.getName());
            Toast.makeText(getApplicationContext(), "Showing Paired Devices",Toast.LENGTH_SHORT).show();
            ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, list);
            lv.setAdapter(adapter);
        }

    }
}