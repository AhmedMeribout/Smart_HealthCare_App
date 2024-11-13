package com.example.healthcare;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.tasks.OnSuccessListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    EditText editpassword , editemail;
    Button loginbutton;
     TextView registerredirectbutton;
    SharedPreferences sharedPreferences,address;
    FusedLocationProviderClient fusedLocationProviderClient;

    String currentlocation;
    private final static int REQUEST_CODE = 100;

    //ProgressBar progressbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //getSupportActionBar().hide();


        editemail = findViewById(R.id.email);
        editpassword = findViewById(R.id.password);
        loginbutton = findViewById(R.id.loginbutton);
        //progressbar= findViewById(R.id.progessbar);
        registerredirectbutton = findViewById(R.id.registerredirectbutton);
        sharedPreferences= getSharedPreferences("login",MODE_PRIVATE);
        SharedPreferences address= getSharedPreferences("address",MODE_PRIVATE);

        String address_=address.getString("address","");

        if (sharedPreferences.getString("logged","false").equals("true")){
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            finish();
        }


        registerredirectbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerpage = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(registerpage);
            }
        });
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //progressbar.setVisibility(View.VISIBLE);
                String email,password;
                email = editemail.getText().toString();
                password = editpassword.getText().toString();
                //getLastLocation();

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(LoginActivity.this, "Enter email", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(password)) {
                    Toast.makeText(LoginActivity.this, "Enter password", Toast.LENGTH_SHORT).show();
                }else {
                    RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                    String url =address_+"log.php";

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Toast.makeText(LoginActivity.this, response, Toast.LENGTH_SHORT).show();
                                    try {
                                        JSONObject jsonObject=new JSONObject(response);
                                        String status = jsonObject.getString("status");
                                        String message = jsonObject.getString("message");
                                        Toast.makeText(getApplicationContext(),status, Toast.LENGTH_SHORT).show();
                                        Toast.makeText(getApplicationContext(),message, Toast.LENGTH_SHORT).show();

                                        if (status.equals("success")){
                                            String email= jsonObject.getString("email");
                                            String id=jsonObject.getString("id");
                                            String apikey= jsonObject.getString("apikey");
                                            Toast.makeText(getApplicationContext(), id, Toast.LENGTH_SHORT).show();
                                            SharedPreferences.Editor editor=sharedPreferences.edit();
                                            editor.putString("email", email);
                                            editor.putString("password", password);
                                            editor.putString("id",id);
                                            editor.putString("apikey",apikey);
                                            editor.putString("logged","true");
                                            editor.apply();
                                            showSuccess();

                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                        Toast.makeText(getApplicationContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                                    }

                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplicationContext(), error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }){
                        protected Map<String, String> getParams(){
                            Map<String, String> paramV = new HashMap<>();
                            paramV.put("password", password);
                            paramV.put("email", email);
                            //paramV.put("location",currentlocation);
                            return paramV;
                        }
                    };
                    queue.add(stringRequest);

                }


            }
        });
    }
    private void showSuccess(){
        ConstraintLayout constraintLayout=findViewById(R.id.successConstraintLayout);
        View view= LayoutInflater.from(LoginActivity.this).inflate(R.layout.success_dialog,constraintLayout);

        Button successDone = view.findViewById(R.id.successDone);
        TextView textView= view.findViewById(R.id.successDesc);
        textView.setText("Login Success");

        AlertDialog.Builder builder=new AlertDialog.Builder(LoginActivity.this);

        //AlertDialog.Builder builder=new android.app.AlertDialog.Builder(MainActivity.this);
        builder.setView(view);
        final AlertDialog alertDialog= builder.create();


        successDone.findViewById(R.id.successDone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();

            }
        });
        if (alertDialog.getWindow()!=null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();

    }
    private void getLastLocation(){

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){


            fusedLocationProviderClient.getLastLocation()
                    .addOnSuccessListener(new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {

                            if (location != null){



                                try {
                                    Geocoder geocoder = new Geocoder(LoginActivity.this, Locale.getDefault());
                                    List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                                    currentlocation = addresses.get(0).getAddressLine(0);

                                } catch (IOException e) {
                                    e.printStackTrace();
                                }


                            }

                        }
                    });


        }else {

            askPermission();


        }


    }

    private void askPermission() {

        ActivityCompat.requestPermissions(LoginActivity.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_CODE);


    }

    public void onRequestPermissionsResult(int requestCode, @NonNull @org.jetbrains.annotations.NotNull String[] permissions, @NonNull @org.jetbrains.annotations.NotNull int[] grantResults) {

        if (requestCode == REQUEST_CODE){

            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){


                getLastLocation();

            }else {


                Toast.makeText(LoginActivity.this,"Please provide the required permission",Toast.LENGTH_SHORT).show();

            }



        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
