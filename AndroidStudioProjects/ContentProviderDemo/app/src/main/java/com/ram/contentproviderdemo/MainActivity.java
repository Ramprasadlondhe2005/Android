package com.ram.contentproviderdemo;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lContact;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lContact=findViewById(R.id.lContact);

        ArrayList<String> contactsArray=new ArrayList<String>();

        ContentResolver oCR=getContentResolver();
        Cursor oC= oCR.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
        while (oC.moveToNext())
        {
            String strData="";
            int iIndex1=oC.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
            strData+=oC.getString(iIndex1);
            int iIndex2=oC.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
            strData+="\n"+oC.getString(iIndex2);
            contactsArray.add(strData);

        }

        ArrayAdapter<String>adapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,contactsArray);
        lContact.setAdapter(adapter);

       lContact.setOnItemClickListener(new AdapterView.OnItemClickListener()
       {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int iPos, long id)
           {
                String strTemp=contactsArray.get(iPos);
                String strContactData[]=strTemp.split("\n");

               Intent intent=new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+strContactData[1]));
               startActivity(intent);
           }
       });
    }
}