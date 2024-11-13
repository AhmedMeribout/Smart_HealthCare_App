package com.example.healthcare;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Edit_info extends AppCompatActivity implements View.OnClickListener {
    CardView weightCardView;
    CardView ageCardView;
    TextView weightCounterText, ageCounterText, height_title_text;
    FloatingActionButton weightBtnInc, ageBtnInc;
    FloatingActionButton weightBtnDec, ageBtnDec;
    int weightCounter = 50;
    int ageCounter = 25;
    String countWeight, countAge;
    NumberPicker feetPicker, inchPicker;
    int feetValue = 150 ;
    Button calculateBtn;
    String heightValue;
    DecimalFormat decimalFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_info);

        weightCardView = findViewById(R.id.weight_cardView);
        weightCounterText = findViewById(R.id.weight_counter_text);
        weightBtnInc = findViewById(R.id.weight_btn_inc);
        weightBtnDec = findViewById(R.id.weight_btn_dec);
        feetPicker = findViewById(R.id.feet_picker);
        calculateBtn = findViewById(R.id.calculate_btn);
        counterInit();
        decimalFormat = new DecimalFormat(".00");
        weightCardView.setOnClickListener(this);
        weightBtnInc.setOnClickListener(this);
        weightBtnDec.setOnClickListener(this);


        SharedPreferences address= getSharedPreferences("address",MODE_PRIVATE);
        String address_=address.getString("address","");
        SharedPreferences sharedPreferences= getSharedPreferences("login",MODE_PRIVATE);
        String id=sharedPreferences.getString("id","");

        feetPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                feetValue = newVal;
                heightValueIs();


            }
        });


        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url =address_+"modify.php";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(Edit_info.this, response, Toast.LENGTH_SHORT).show();
                                if (response.equals("Success")){
                                    showSuccess();

                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
                    protected Map<String, String> getParams(){
                        Map<String, String> paramV = new HashMap<>();
                        paramV.put("id", id);
                        paramV.put("height", String.valueOf(feetValue));
                        paramV.put("weight", String.valueOf(weightCounter));
                        return paramV;
                    }
                };
                queue.add(stringRequest);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.weight_cardView:
                break;
            case R.id.weight_btn_inc:
                if(weightCounter < 700)
                    weightCounter++;
                countWeight = Integer.toString(weightCounter);
                weightCounterText.setText(countWeight);
                break;
            case R.id.weight_btn_dec:
                if(weightCounter > 0)
                    weightCounter--;
                countWeight = Integer.toString(weightCounter);
                weightCounterText.setText(countWeight);
                break;

        }

    }
    private void counterInit() {
        countWeight = Integer.toString(weightCounter);
        weightCounterText.setText(countWeight);
        countAge = Integer.toString(ageCounter);
        feetPicker.setMinValue(1);
        feetPicker.setMaxValue(250);
        feetPicker.setValue(150);
        heightValueIs();
    }
    public void heightValueIs()
    {
        heightValue = String.valueOf(feetValue);
    }
    private void showSuccess(){
        ConstraintLayout constraintLayout=findViewById(R.id.successConstraintLayout);
        View view= LayoutInflater.from(Edit_info.this).inflate(R.layout.success_dialog,constraintLayout);

        Button successDone = view.findViewById(R.id.successDone);
        TextView textView= view.findViewById(R.id.successDesc);
        textView.setText("infomation edited Successfuly");

        AlertDialog.Builder builder=new AlertDialog.Builder(Edit_info.this);

        //AlertDialog.Builder builder=new android.app.AlertDialog.Builder(MainActivity.this);
        builder.setView(view);
        final AlertDialog alertDialog= builder.create();


        successDone.findViewById(R.id.successDone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        if (alertDialog.getWindow()!=null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();

    }


}