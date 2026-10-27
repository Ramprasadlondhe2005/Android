package com.ram.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class PowerConnection extends BroadcastReceiver
{
    @Override
    public void onReceive(Context c, Intent i)
    {
        if(i.getAction().equals(i.ACTION_POWER_CONNECTED))
        {
            Toast.makeText(c, "Charger Connected", Toast.LENGTH_LONG).show();
        }
        else if(i.getAction().equals(i.ACTION_POWER_DISCONNECTED))
        {
            Toast.makeText(c, "Charger Disconnected", Toast.LENGTH_LONG).show();
        }
    }
}
