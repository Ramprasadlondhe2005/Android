package com.example.receivemessage;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class ReceiveSMSActivity extends AppCompatActivity {
    ArrayList<String> smsMessagesList = new ArrayList<>();
    ListView smsListView;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        smsListView = findViewById(R.id.SMSList);
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, smsMessagesList);
        smsListView.setAdapter(arrayAdapter);

        fetchSMSFromInbox();
    }

    private void fetchSMSFromInbox() {
        Uri uri = Uri.parse("content://sms/inbox");
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                String address = cursor.getString(cursor.getColumnIndexOrThrow("address"));
                String body = cursor.getString(cursor.getColumnIndexOrThrow("body"));
                smsMessagesList.add("From: " + address + "\n" + "Message: " + body);
            } while (cursor.moveToNext());

            cursor.close();
            arrayAdapter.notifyDataSetChanged();

            // Finish the activity after displaying messages
            finish();
        }
    }
}
