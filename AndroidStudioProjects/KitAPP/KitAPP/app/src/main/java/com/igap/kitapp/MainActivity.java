package com.igap.kitapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    ListView lView;
    ProgressDialog pDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lView = findViewById(R.id.lView);
        list();
    }

    private void list() {
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("downloading, please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(true);
        pDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                finish();
            }
        });
        pDialog.show();

        String url = "https://kit.igaptechnologies.com/students.php";
        StringRequest stringRequest = new StringRequest(com.android.volley.Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        pDialog.dismiss();
                        Log.d("Response ", ">> " + response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonData = jsonObject.getJSONArray("data");
                            ArrayList<String> students = new ArrayList<>();
                            for (int i = 0; i < jsonData.length(); i++) {

                                JSONObject jo = jsonData.getJSONObject(i);
                                String student =   jo.getString("name") + " - "+ jo.getString("email");  ;
                                students.add(student);
                            }
                            ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1, android.R.id.text1, students);
                            lView.setAdapter(adapter);
                        } catch (Exception e) {
                            Log.e("Exception ", ">> " + e);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error ", ">> " + error);
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }

    public void btnAddStudentClick(View view) {
        Intent intent = new Intent(this, AddStudentActivity.class);
        startActivity(intent);
    }
}