package com.ram.sqldemo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.*;


public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    EditText idEditText, nameEditText, mobileEditText, addressEditText, pincodeEditText, searchIdEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = openOrCreateDatabase("AndroidJSonDataBase", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS AndroidJSonTable(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, cid VARCHAR, name VARCHAR, mobile VARCHAR, address VARCHAR, pincode VARCHAR);");

        idEditText = findViewById(R.id.editid);
        nameEditText = findViewById(R.id.editname);
        mobileEditText = findViewById(R.id.editmobile);
        addressEditText = findViewById(R.id.editaddress);
        pincodeEditText = findViewById(R.id.editpincode);
        searchIdEditText = findViewById(R.id.editsearchid);

        Button enterDataButton = findViewById(R.id.button);
        enterDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cid = idEditText.getText().toString();
                String name = nameEditText.getText().toString();
                String mobile = mobileEditText.getText().toString();
                String address = addressEditText.getText().toString();
                String pincode = pincodeEditText.getText().toString();

                String sql = "INSERT INTO AndroidJSonTable (cid, name, mobile, address, pincode) VALUES('" + cid + "', '" + name + "', '" + mobile + "', '" + address + "', '" + pincode + "');";
                db.execSQL(sql);
                Toast.makeText(getApplicationContext(), "Data Inserted Successfully", Toast.LENGTH_LONG).show();
            }
        });

        Button searchDataButton = findViewById(R.id.button1);
        searchDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String searchId = searchIdEditText.getText().toString();
                Cursor cursor = db.rawQuery("SELECT * FROM AndroidJSonTable WHERE cid='" + searchId + "'", null);

                if (cursor.moveToFirst()) {
                    StringBuffer buffer = new StringBuffer();
                    do {
                        String cid = cursor.getString(1);
                        String name = cursor.getString(2);
                        String mobile = cursor.getString(3);
                        String address = cursor.getString(4);
                        String pincode = cursor.getString(5);
                        buffer.append(cid + " " + name + " " + mobile + " " + address + " " + pincode + "\n");
                    } while (cursor.moveToNext());
                    Toast.makeText(getApplicationContext(), buffer.toString(), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "No data found", Toast.LENGTH_LONG).show();
                }
                cursor.close();
            }
        });
    }
}
