package com.example.healthcare;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class addBalance extends AppCompatActivity {
    EditText amont,card,pin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_balance);

        amont=findViewById(R.id.amont);
        card=findViewById(R.id.card);
        pin=findViewById(R.id.pin);

        SharedPreferences address= getSharedPreferences("address",MODE_PRIVATE);
        String address_=address.getString("address","");
        SharedPreferences sharedPreferences= getSharedPreferences("login",MODE_PRIVATE);
        String id=sharedPreferences.getString("id","");
        String balance=sharedPreferences.getString("balance","");

        int balance_int = Integer.parseInt(balance);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Add Funds");
        Button press=findViewById(R.id.press);
        press.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String amont_S=amont.getText().toString();
                String card_S=card.getText().toString();
                String pin_S=pin.getText().toString();
                if (amont_S.equals("")){
                    Toast.makeText(addBalance.this, "enter ur amount that you wanna add", Toast.LENGTH_SHORT).show();
                } else if (card_S.equals("")) {
                    Toast.makeText(addBalance.this, "enter ur card number", Toast.LENGTH_SHORT).show();
                } else if (pin_S.equals("")) {
                    Toast.makeText(addBalance.this, "enter ur pin key", Toast.LENGTH_SHORT).show();
                }else {

                int amont_int = Integer.parseInt(amont_S);

                int balance_int1 = balance_int +amont_int;
                String balance1 = Integer.toString(balance_int1);
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url =address_+"add.php";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(addBalance.this, response, Toast.LENGTH_SHORT).show();
                                if (response.equals("Success")){
                                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //
                    }
                }){
                    protected Map<String, String> getParams(){
                        Map<String, String> paramV = new HashMap<>();
                        paramV.put("id", id);
                        paramV.put("balance", balance1);
                        return paramV;
                    }
                };
                queue.add(stringRequest);
            }
            }

        });


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}