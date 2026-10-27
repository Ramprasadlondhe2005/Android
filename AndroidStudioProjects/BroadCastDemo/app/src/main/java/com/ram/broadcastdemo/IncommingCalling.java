package com.ram.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class IncommingCalling extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        String strState=intent.getStringExtra(TelephonyManager.EXTRA_STATE);
        if(strState.equals(TelephonyManager.EXTRA_STATE_RINGING))
        {
            Toast.makeText(context, "Phone is Ringging",Toast.LENGTH_LONG).show();
        }
        else if(strState.equals(TelephonyManager.EXTRA_STATE_OFFHOOK))
        {
            Toast.makeText(context,"Phone call is Picked",Toast.LENGTH_LONG).show();
        }
        else if(strState.equals(TelephonyManager.EXTRA_STATE_IDLE))
        {
            Toast.makeText(context,"Phone call Ended", Toast.LENGTH_LONG).show();
        }


    }
}
