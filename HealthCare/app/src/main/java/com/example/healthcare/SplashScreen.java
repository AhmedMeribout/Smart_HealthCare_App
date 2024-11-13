package com.example.healthcare;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class SplashScreen extends AppCompatActivity {
    public static int SPLASH_TIMER = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        androidx.cardview.widget.CardView pannel=findViewById(R.id.pannel);
        pannel.setVisibility(View.GONE);
        Button reconnect=findViewById(R.id.reconnect);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        int colorCodeDark = Color.parseColor("#3FAA81");
        window.setStatusBarColor(colorCodeDark);
        SharedPreferences address= getSharedPreferences("address",MODE_PRIVATE);
        SharedPreferences.Editor editor_address=address.edit();
        String final_address="https://da37-105-106-225-163.ngrok-free.app/";

        editor_address.putString("address", final_address+"si/");
        editor_address.putString("addressi", final_address+"si/");
        editor_address.putString("address_without", final_address);

        editor_address.apply();
        String address_=address.getString("address","");

        try {


        RequestQueue queue = Volley.newRequestQueue(this);
        String url =address_+"connect.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equals("Success")){
                            splash();
                        }else {
                            Toast.makeText(SplashScreen.this, "You are not connected to the server", Toast.LENGTH_SHORT).show();
                            pannel.setVisibility(View.VISIBLE);
                            reconnect.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(getApplicationContext(),SplashScreen.class);
                                    startActivity(intent);
                                    finish();
                                }
                            });
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SplashScreen.this, "You are not connected to the server", Toast.LENGTH_SHORT).show();
                pannel.setVisibility(View.VISIBLE);
                reconnect.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(getApplicationContext(),SplashScreen.class);
                        startActivity(intent);
                        finish();
                    }
                });

            }
        }){
            protected Map<String, String> getParams(){
                Map<String, String> paramV = new HashMap<>();
                paramV.put("param", "abc");
                return paramV;
            }
        };
        queue.add(stringRequest);
        }catch (Exception e){
            Toast.makeText(SplashScreen.this, "You are not connected to the server", Toast.LENGTH_SHORT).show();
            pannel.setVisibility(View.VISIBLE);
            reconnect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(getApplicationContext(),SplashScreen.class);
                    startActivity(intent);
                    finish();
                }
            });
        }


    }
    public void splash(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIMER);
    }

}