package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddFriendActivity extends AppCompatActivity {
    SQLiteDatabase database;
    EditText etxtName, etxtMobileno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);
        etxtName = findViewById(R.id.etxtName);
        etxtMobileno = findViewById(R.id.etxtMobileno);

        database = openOrCreateDatabase("friendbook", MODE_PRIVATE, null);
        String query = "CREATE TABLE IF NOT EXISTS friends(name VARCHAR, mobileno VARCHAR)";
        database.execSQL(query);
    }

    public void btnAddFriendClick(View view) {
        String name = etxtName.getText().toString().trim();
        String mobileno = etxtMobileno.getText().toString().trim();
        if(name.equals("")){
            etxtName.setError("Enter name");
            return;
        }
        if(mobileno.length() != 10){
            etxtMobileno.setError("Enter 10 digit mobile no");
            return;
        }
        String query = "INSERT INTO friends(name, mobileno) VALUES('" + name + "', '" + mobileno + "')";
        database.execSQL(query);
        Toast.makeText(this,"Friend added", Toast.LENGTH_SHORT).show();
    }
}