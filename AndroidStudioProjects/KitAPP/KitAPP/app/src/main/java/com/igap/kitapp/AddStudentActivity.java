package com.igap.kitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class AddStudentActivity extends AppCompatActivity {

    EditText etxtName, etxtEmail, etxtMobileno;
    String name="", email="", mobileno="";
    ProgressDialog pDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        etxtName = findViewById(R.id.etxtName);
        etxtEmail = findViewById(R.id.etxtEmail);
        etxtMobileno = findViewById(R.id.etxtMobileno);
    }

    public void btnSubmitClick(View view) {
        name = etxtName.getText().toString();
        email = etxtEmail.getText().toString();
        mobileno = etxtMobileno.getText().toString();

        if(name.equals(""))
        {
            etxtName.setError("Please enter name");
            etxtName.requestFocus();
            return;
        }
        if(email.equals(""))
        {
            etxtEmail.setError("Please enter email");
            etxtEmail.requestFocus();
            return;
        }
        if(mobileno.equals(""))
        {
            etxtMobileno.setError("Please enter mobile no");
            etxtMobileno.requestFocus();
            return;
        }

        pDialog = new ProgressDialog(AddStudentActivity.this);
        pDialog.setMessage("validating your details, please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(true);
        pDialog.show();

        String url = "https://kit.igaptechnologies.com/addstudent.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject jsonObject = null;
                        Log.d("Response", ">> "+response);
                        pDialog.dismiss();
                        try {
                            jsonObject = new JSONObject(response);

                            Log.e( "onResponse: ", jsonObject.getString("status") );

                            if(jsonObject.getString("status").equals("success")) {

                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                                finish();

                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(), "Record Not Added ...Failed...", Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            Toast.makeText(getApplicationContext(), "Check Internet Connection...", Toast.LENGTH_LONG).show();
                            Log.e("Exception", ">> "+e);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pDialog.dismiss();
                        Log.e("Exception", error.toString());
                        Toast.makeText(getApplicationContext(), "Check Internet Connection...", Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String> params = new HashMap<>();
                params.put("name", name);
                params.put("email", email);
                params.put("mobileno", mobileno);
                Log.e("Params", params.toString());
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);




    }
}