package com.ram.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BatteryStatus extends BroadcastReceiver
{
    @Override
    public void onReceive(Context c, Intent in)
    {
        if(in.getAction().equals(in.ACTION_BATTERY_LOW))
        {
            Toast.makeText(c, "Battery is low", Toast.LENGTH_LONG).show();
        }
        else if(in.getAction().equals(in.ACTION_BATTERY_OKAY))
        {
            Toast.makeText(c, "Battery is ok", Toast.LENGTH_LONG).show();
        }
    }
}