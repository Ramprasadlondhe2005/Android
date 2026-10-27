package com.ram.pkbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class callingIntent extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        String strState=intent.getStringExtra(TelephonyManager.EXTRA_STATE);
        if(strState.equals(TelephonyManager.EXTRA_STATE_RINGING))
        {
            Toast.makeText(context, "Ringing", Toast.LENGTH_SHORT).show();
        }
        if (strState.equals(TelephonyManager.EXTRA_STATE_OFFHOOK))
        {
            Toast.makeText(context, "Pick up", Toast.LENGTH_SHORT).show();
        }
        if (strState.equals(TelephonyManager.EXTRA_STATE_IDLE))
        {
            Toast.makeText(context, "Cut", Toast.LENGTH_SHORT).show();
        }

    }
}
