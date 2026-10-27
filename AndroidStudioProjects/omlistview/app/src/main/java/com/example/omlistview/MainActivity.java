package com.example.omlistview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=findViewById(R.id.lv);

        String strArr[]={"MAD","php","java","python","android","nis","mgt"};
        ArrayAdapter<String> adpter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,strArr);
        lv.setAdapter(adpter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String strItem=adpter.getItem(position);
                Toast.makeText(MainActivity.this,strItem, Toast.LENGTH_SHORT).show();
            }
        });
    }
}