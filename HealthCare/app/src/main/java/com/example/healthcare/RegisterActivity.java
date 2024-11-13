package com.example.healthcare;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.healthcare.databinding.ActivityMainBinding;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    EditText editpassword , editemail , firstname , lastname , age , bd,country , city , address,Phone,emergencyphone ,height,weight,currentjob,previousjob,disease,activities,idcard;
    RadioGroup smoking, gender;
    ImageView ur_pic;
    RadioButton selectedgender,selectedsmoking;
    Button registerbutton,loginredirectbutton,ur_pic_btn;
    //ProgressBar progressbar;
    Bitmap bitmap;
    ByteArrayOutputStream byteArrayOutputStream;
    String[] items =  {"A+","A-","B+","B-","O+","O-","AB+","AB-"};
    AutoCompleteTextView autoCompleteTxt;
    ArrayAdapter<String> adapterItems;
    String bloodtype,Date;
    DatePickerDialog picker;
    ActivityMainBinding binding;
    String usergender;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setContentView(R.layout.activity_register);
        SharedPreferences addresss= getSharedPreferences("address",MODE_PRIVATE);
        String address_=addresss.getString("address","");
        ActivityResultLauncher<Intent> activityResultLauncher=
                registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode()== Activity.RESULT_OK){
                            Intent data = result.getData();
                            Uri uri=data.getData();
                            try {
                                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
                                ur_pic.setImageBitmap(bitmap);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }

                    }
                });

        autoCompleteTxt = findViewById(R.id.auto_complete_txt);

        adapterItems = new ArrayAdapter<String>(this,R.layout.list_item,items);
        autoCompleteTxt.setAdapter(adapterItems);



        autoCompleteTxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"Item: "+item,Toast.LENGTH_SHORT).show();
                bloodtype=item;
            }
        });
        Date= "0000-00-00";


        ur_pic=findViewById(R.id.ur_pic);


        ur_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_PICK);
                intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                activityResultLauncher.launch(intent);
            }
        });


        editemail = findViewById(R.id.email);
        editpassword = findViewById(R.id.password);
        registerbutton = findViewById(R.id.registerbutton);
        //progressbar= findViewById(R.id.progessbar);
        loginredirectbutton= findViewById(R.id.loginredirectbutton);
        firstname = findViewById(R.id.FirstName);
        lastname = findViewById(R.id.LastName);

         bd = findViewById(R.id.dateofbirth);
         //gender= findViewById(R.id.gender);
         //gender.clearCheck();
         country= findViewById(R.id.country);
         city= findViewById(R.id.city);
         address= findViewById(R.id.address);
         Phone= findViewById(R.id.phone);
         emergencyphone= findViewById(R.id.emergency_phone);
         height= findViewById(R.id.height);
         weight= findViewById(R.id.weight);
         disease= findViewById(R.id.diseases);
         idcard = findViewById(R.id.ID_code);
         currentjob= findViewById(R.id.cu_job);


        RelativeLayout male = findViewById(R.id.male);
        RelativeLayout female = findViewById(R.id.female);

        male.setOnClickListener(view ->{
            male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.card_back_btn));
            female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.card_back_not_focus));
            usergender="Male";
        });
        female.setOnClickListener(view ->{
            female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.card_back_btn));
            male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.card_back_not_focus));
            usergender="Female";
        });









         bd.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 final Calendar calendar=Calendar.getInstance();
                 int day=calendar.get(Calendar.DAY_OF_MONTH);
                 int month=calendar.get(Calendar.MONTH);
                 int year =calendar.get(Calendar.YEAR);

                 picker = new DatePickerDialog(RegisterActivity.this, new DatePickerDialog.OnDateSetListener() {
                     @Override
                     public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        bd.setText(year+"-"+(month+1)+"-"+dayOfMonth);
                        Date=year+"-"+(month+1)+"-"+dayOfMonth;
                     }
                 },year,month,day);
                 picker.show();
             }
         });





        loginredirectbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginpage = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(loginpage);
            }
        });

        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String base64Image;

                byteArrayOutputStream= new ByteArrayOutputStream();
                if (bitmap!= null) {
                    bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
                    byte[] bytes = byteArrayOutputStream.toByteArray();
                    base64Image = Base64.encodeToString(bytes,Base64.DEFAULT);

                }else base64Image="";
                //progressbar.setVisibility(View.VISIBLE);
                //int selectedgenderid = gender.getCheckedRadioButtonId();

                //selectedgender = findViewById(selectedgenderid);

                String email,password;
                email = String.valueOf(editemail.getText()).trim();
                password = String.valueOf(editpassword.getText()).trim();
                String firstnametext = String.valueOf(firstname.getText());
                String lastnametext= String.valueOf(lastname.getText()).trim();
                String dbtext = String.valueOf(bd.getText()).trim();
                String  countrytext= String.valueOf(country.getText()).trim();
                String citytext = String.valueOf(city.getText()).trim();
                String addresstext= String.valueOf(address.getText()).trim();
                String phone= String.valueOf(Phone.getText()).trim();
                String emergencyphonetext= String.valueOf(emergencyphone.getText()).trim();
                String heighttext= String.valueOf(height.getText()).trim();
                String weighttext= String.valueOf(weight.getText()).trim();
                String diseasetext= String.valueOf(disease.getText()).trim();
                String idcardtext= String.valueOf(idcard.getText()).trim();
                String cu_job=String.valueOf(currentjob.getText()).trim();

                String textgender , textsmoker;



                if (TextUtils.isEmpty(email)){
                    Toast.makeText(RegisterActivity.this, "Enter email", Toast.LENGTH_SHORT).show();
                    editemail.requestFocus();
                } else if (TextUtils.isEmpty(password)) {
                    Toast.makeText(RegisterActivity.this, "Enter password", Toast.LENGTH_SHORT).show();
                    editpassword.requestFocus();
                } else if ( TextUtils.isEmpty(firstnametext)) {
                    Toast.makeText(RegisterActivity.this, "enter ur firstname", Toast.LENGTH_SHORT).show();
                    firstname.requestFocus();

                } else if ( TextUtils.isEmpty(lastnametext)) {
                    Toast.makeText(RegisterActivity.this, "enter ur lastname", Toast.LENGTH_SHORT).show();
                    lastname.requestFocus();

                } else if ( TextUtils.isEmpty(dbtext)) {
                    Toast.makeText(RegisterActivity.this, "enter ur birth data", Toast.LENGTH_SHORT).show();
                    bd.requestFocus();

                } else if ( TextUtils.isEmpty(countrytext)) {
                    Toast.makeText(RegisterActivity.this, "enter ur country", Toast.LENGTH_SHORT).show();
                    country.requestFocus();

                } else if ( TextUtils.isEmpty(citytext)) {
                    Toast.makeText(RegisterActivity.this, "enter ur city", Toast.LENGTH_SHORT).show();
                    city.requestFocus();

                } else if ( TextUtils.isEmpty(addresstext)) {
                    Toast.makeText(RegisterActivity.this, "enter ur address", Toast.LENGTH_SHORT).show();
                    address.requestFocus();

                } else if ( TextUtils.isEmpty(phone)) {
                    Toast.makeText(RegisterActivity.this, "enter ur phone", Toast.LENGTH_SHORT).show();
                    Phone.requestFocus();

                } else if ( TextUtils.isEmpty(emergencyphonetext)) {
                    Toast.makeText(RegisterActivity.this, "enter ur emergency phone", Toast.LENGTH_SHORT).show();
                    emergencyphone.requestFocus();

                } else if ( TextUtils.isEmpty(heighttext)) {
                    Toast.makeText(RegisterActivity.this, "enter ur height", Toast.LENGTH_SHORT).show();
                    height.requestFocus();

                } else if ( TextUtils.isEmpty(weighttext)) {
                    Toast.makeText(RegisterActivity.this, "enter ur weight", Toast.LENGTH_SHORT).show();
                    weight.requestFocus();

                } else if ( TextUtils.isEmpty(idcardtext)) {
                    Toast.makeText(RegisterActivity.this, "enter ur id card number", Toast.LENGTH_SHORT).show();
                    idcard.requestFocus();

                } else if ( TextUtils.isEmpty(cu_job)) {
                    Toast.makeText(RegisterActivity.this, "enter ur job", Toast.LENGTH_SHORT).show();
                    currentjob.requestFocus();

                } else if ( TextUtils.isEmpty(bloodtype)) {
                    Toast.makeText(RegisterActivity.this, "select ur blood type", Toast.LENGTH_SHORT).show();

            }else {//textgender = selectedgender.getText().toString();
                    /*
                    textgender = selectedgender.getText().toString();
                    textsmoker = selectedsmoking.getText().toString();
                    mAuth=FirebaseAuth.getInstance();
                    mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            //progressbar.setVisibility(View.GONE);
                            if (task.isSuccessful()) {
                                ReadwriteUserdetails writeuserdetails = new ReadwriteUserdetails(firstnametext,lastnametext,agetext,dbtext,textgender,countrytext,citytext,addresstext,phone,emergencyphonetext,heighttext,weighttext,currentjobtext,previousjobtext,diseasetext,activitiestext,textsmoker,idcardtext);

                                DatabaseReference referenceprofiel = FirebaseDatabase.getInstance("https://fir-test2-b505a-default-rtdb.europe-west1.firebasedatabase.app").getReference("Users");

                                referenceprofiel.child(mAuth.getUid()).setValue(writeuserdetails).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        Toast.makeText(RegisterActivity.this, "Account Created", Toast.LENGTH_SHORT).show();
                                        Intent mainpage= new Intent(getApplicationContext(),MainActivity.class);
                                        startActivity(mainpage);
                                        finish();

                                    }
                                });





                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                    //registeruser(email,password,firstnametext,lastnametext,agetext,dbtext,textgender,countrytext,citytext,addresstext,phone,emergencyphonetext,heighttext,weighttext,currentjobtext,previousjobtext,diseasetext,activitiestext,textsmoker,idcardtext);
                */

                /*RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url ="https://192.168.1.3/login_regi/reg.php";

                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                //
                            }
                        }, new Response.ErrorListener() {


                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //
                    }
                });

                queue.add(stringRequest);
            */
                    RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                    String url =address_+"reg.php";

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Toast.makeText(RegisterActivity.this, response, Toast.LENGTH_SHORT).show();

                                    if (response.equals("SuccessSuccess")){
                                        showSuccess();

                                    }else
                                        //currentjob.setText(response);
                                        Toast.makeText(RegisterActivity.this, "Duplicated Email", Toast.LENGTH_SHORT).show();
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                        }
                    }){
                        protected Map<String, String> getParams(){
                            Map<String, String> paramV = new HashMap<>();
                            paramV.put("password", password);
                            paramV.put("email", email);
                            paramV.put("firstname", firstnametext);
                            paramV.put("lastname", lastnametext);
                            paramV.put("birth", Date);
                            paramV.put("country", countrytext);
                            paramV.put("city", citytext);
                            paramV.put("address", addresstext);
                            paramV.put("phone", phone);
                            paramV.put("em_phone", emergencyphonetext);
                            paramV.put("height", heighttext);
                            paramV.put("weight", weighttext);
                            paramV.put("desease", diseasetext);
                            paramV.put("id_card", idcardtext);
                            paramV.put("gender", usergender);
                            paramV.put("bloodtype", bloodtype);
                            paramV.put("image", base64Image);
                            paramV.put("cu_job", cu_job);

                            return paramV;
                        }
                    };
                    queue.add(stringRequest);

                }


            }
        });


    }

    private void registeruser(String email,String password,String firstnametext, String lastnametext, String agetext, String dbtext, String textgender, String countrytext, String citytext, String addresstext, String phone, String emergencyphonetext, String heighttext, String weighttext, String currentjobtext, String previousjobtext, String diseasetext, String activitiestext, String textsmoker, String idcardtext) {






    }
    private void showSuccess(){
        ConstraintLayout constraintLayout=findViewById(R.id.successConstraintLayout);
        View view= LayoutInflater.from(RegisterActivity.this).inflate(R.layout.success_dialog,constraintLayout);

        Button successDone = view.findViewById(R.id.successDone);
        TextView textView= view.findViewById(R.id.successDesc);
        textView.setText("Register Success");

        AlertDialog.Builder builder=new AlertDialog.Builder(RegisterActivity.this);

        //AlertDialog.Builder builder=new android.app.AlertDialog.Builder(MainActivity.this);
        builder.setView(view);
        final AlertDialog alertDialog= builder.create();


        successDone.findViewById(R.id.successDone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
                Intent intent =new Intent(getApplicationContext(),LoginActivity.class);
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












