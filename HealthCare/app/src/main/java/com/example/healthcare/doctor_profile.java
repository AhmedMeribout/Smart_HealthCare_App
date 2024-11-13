package com.example.healthcare;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

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

public class doctor_profile extends AppCompatActivity {
    TextView doctor_name,email,phone,speciality,description;

    Button appointment;
    private static final int REQUEST_CALL = 1;

    public void sendEmail(String to_email){
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,new String[]{to_email});
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"choose email client:"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_profile);

        SharedPreferences address= getSharedPreferences("address",MODE_PRIVATE);
        String address_=address.getString("address","");
        RequestQueue queue = Volley.newRequestQueue(this);
        SharedPreferences sharedPreferences= getSharedPreferences("login",MODE_PRIVATE);

        Bundle extras = getIntent().getExtras();
        String doctor_id= extras.getString("doctor_id");
        Toast.makeText(this, doctor_id, Toast.LENGTH_SHORT).show();
        doctor_name=findViewById(R.id.doctor_name);
        email=findViewById(R.id.email);
        phone=findViewById(R.id.phone);
        speciality=findViewById(R.id.speciality);
        description=findViewById(R.id.description);
        appointment=findViewById(R.id.appointment);

        appointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url =address_+"appointment.php";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if(response.contains("funds")){
                                    Intent i = new Intent(doctor_profile.this, addBalance.class);
                                    startActivity(i);
                                }

                                //doctor_name.setText(response-);
                                //Toast.makeText(doctor_profile.this, response, Toast.LENGTH_SHORT).show();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //
                    }
                }){
                    protected Map<String, String> getParams(){
                        Map<String, String> paramV = new HashMap<>();
                        paramV.put("idd", doctor_id);
                        paramV.put("idu",sharedPreferences.getString("id",""));

                        return paramV;
                    }
                };
                queue.add(stringRequest);

            }
        });



        String url =address_+"doctor_info.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            String status = jsonObject.getString("status");
                            if (status.equals("data fetched")){
                                String name_S=jsonObject.getString("name");
                                String speciality_S=jsonObject.getString("speciality");
                                String phone_S=jsonObject.getString("phone");
                                String doctor_desc=jsonObject.getString("doctor_desc");
                                String email_S=jsonObject.getString("email");
                                doctor_name.setText(name_S);
                                email.setText(email_S);
                                phone.setText(phone_S);
                                speciality.setText(speciality_S);
                                description.setText(doctor_desc);
                                phone.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        makePhoneCall(phone_S);
                                    }
                                });
                                email.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        sendEmail(email_S);
                                    }
                                });

                            }
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                        //
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //
            }
        }){
            protected Map<String, String> getParams(){
                Map<String, String> paramV = new HashMap<>();
                paramV.put("id", doctor_id);
                return paramV;
            }
        };
        queue.add(stringRequest);







    }
    private void makePhoneCall(String number) {
        if (number.trim().length() > 0) {

            if (ContextCompat.checkSelfPermission(doctor_profile.this,
                    android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(doctor_profile.this,
                        new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }

        } else {
            Toast.makeText(doctor_profile.this, "there is no number", Toast.LENGTH_SHORT).show();
        }
    }
}