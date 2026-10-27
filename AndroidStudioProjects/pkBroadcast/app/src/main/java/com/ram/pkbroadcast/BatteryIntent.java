package com.ram.pkbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BatteryIntent extends BroadcastReceiver
{

    @Override
    public void onReceive(Context context, Intent intent)
    {
        if(intent.getAction().equals(intent.ACTION_BATTERY_LOW))
        {
            Toast.makeText(context, "Battery Is Low", Toast.LENGTH_SHORT).show();
        }
        else if(intent.getAction().equals(intent.ACTION_BATTERY_OKAY))
        {
            Toast.makeText(context, "Battery Is Ok", Toast.LENGTH_SHORT).show();
        }
    }
}
