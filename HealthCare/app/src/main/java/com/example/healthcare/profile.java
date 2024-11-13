package com.example.healthcare;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class profile extends AppCompatActivity {
    TextView gender_s,name_s,height_s,weight_s,email_s,date,phone_s,address_s;
    ImageView qrcodei,profile,logout;
    Button delete_user;

    public void image_put(String image){
        SharedPreferences address= getSharedPreferences("address",MODE_PRIVATE);
        String address_=address.getString("addressi","");
        Glide.with(this).load(address_+image).into(profile);
        //Toast.makeText(this, image, Toast.LENGTH_SHORT).show();
    }
    public void goback(View view) {
        onBackPressed();
    }


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //getSupportActionBar().hide();
        Window window = getWindow();

        delete_user=findViewById(R.id.delete_user);
        delete_user.setBackgroundColor(getResources().getColor(R.color.red));

        SharedPreferences address= getSharedPreferences("address",MODE_PRIVATE);
        String address_=address.getString("address","");




        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        int colorCodeDark = Color.parseColor("#3FAA81");
        window.setStatusBarColor(colorCodeDark);



        name_s=findViewById(R.id.fullname);
        height_s=findViewById(R.id.height);
        weight_s=findViewById(R.id.weight);
        gender_s=findViewById(R.id.genderu);
        date=findViewById(R.id.date);
        email_s=findViewById(R.id.email);
        phone_s=findViewById(R.id.phone);
        address_s=findViewById(R.id.address);
        qrcodei=findViewById(R.id.qrcode);
        profile=findViewById(R.id.profile);

        SharedPreferences sharedPreferences= getSharedPreferences("login",MODE_PRIVATE);
        SharedPreferences sharedqr= getSharedPreferences("qr",MODE_PRIVATE);
        String email_v=sharedPreferences.getString("email","");
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url =address_+"prof.php";





        Button edit_info= findViewById(R.id.edit_info);
        edit_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), Edit_info.class);
                startActivity(intent);
            }
        });
        logout=findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url =address_+"logout.php";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if (response.equals("success")) {

                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                    editor.putString("email", "");
                                    editor.putString("password", "");
                                    editor.putString("apikey", "");
                                    editor.putString("logged", "");
                                    editor.apply();
                                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                    startActivity(intent);
                                    finish();

                                }else
                                    Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                }){
                    protected Map<String, String> getParams(){
                        Map<String, String> paramV = new HashMap<>();

                        paramV.put("apikey", sharedPreferences.getString("apikey",""));
                        paramV.put("email", sharedPreferences.getString("email",""));

                        return paramV;
                    }
                };
                queue.add(stringRequest);
            }
        });



        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            String status = jsonObject.getString("status");
                            String message = jsonObject.getString("message");
                            if (status.equals("data fetched")){
                                String firstname= jsonObject.getString("firstname");
                                String lastname= jsonObject.getString("lastname");
                                String age= jsonObject.getString("age");
                                String birth= jsonObject.getString("birth");
                                String gender= jsonObject.getString("gender");
                                String country= jsonObject.getString("country");
                                String city= jsonObject.getString("city");
                                String address= jsonObject.getString("address");
                                String phone= jsonObject.getString("phone");
                                String em_phone= jsonObject.getString("em_phone");
                                String height= jsonObject.getString("height");
                                String weight= jsonObject.getString("weight");
                                String cu_job= jsonObject.getString("cu_job");
                                String pre_job= jsonObject.getString("pre_job");
                                String desease= jsonObject.getString("desease");
                                String id_card= jsonObject.getString("id_card");
                                String bloodtype= jsonObject.getString("bloodtype");
                                String image=jsonObject.getString("image");

                                image_put(image);

                                name_s.setText(firstname+" "+lastname);
                                gender_s.setText(gender);
                                height_s.setText(height+"CM");
                                weight_s.setText(weight+"kg");
                                email_s.setText(email_v);
                                date.setText(birth);
                                phone_s.setText(phone);
                                address_s.setText(address);
                                qrcodei.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {

                                        SharedPreferences.Editor editorqr=sharedqr.edit();
                                        editorqr.putString("qrinfo",response);
                                        editorqr.putString("firstname",firstname);
                                        editorqr.putString("lastname",lastname);
                                        editorqr.putString("birth",birth);
                                        editorqr.putString("gender",gender);
                                        editorqr.putString("address",address);
                                        editorqr.putString("phone",phone);
                                        editorqr.putString("height",height);
                                        editorqr.putString("weight",weight);
                                        editorqr.putString("bloodtype",bloodtype);
                                        editorqr.apply();
                                        Intent intent=new Intent(getApplicationContext(),qrcode.class);
                                        startActivity(intent);
                                    }
                                });

                            }

                            Toast.makeText(getApplicationContext(),status, Toast.LENGTH_SHORT).show();
                            Toast.makeText(getApplicationContext(),message, Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
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

                paramV.put("id", sharedPreferences.getString("id",""));

                return paramV;
            }
        };
        queue.add(stringRequest);
        delete_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url =address_+"drop.php";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                SharedPreferences.Editor editor=sharedPreferences.edit();
                                editor.putString("email", "");
                                editor.putString("password", "");
                                editor.putString("id","");
                                editor.putString("apikey","");
                                editor.putString("logged","");
                                editor.apply();
                                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                                startActivity(intent);
                                finish();


                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
                    protected Map<String, String> getParams(){
                        Map<String, String> paramV = new HashMap<>();
                        paramV.put("id", sharedPreferences.getString("id",""));
                        return paramV;
                    }
                };
                queue.add(stringRequest);
            }
        });
    }
}