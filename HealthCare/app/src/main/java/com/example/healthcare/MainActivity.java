package com.example.healthcare;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.healthcare.databinding.ActivityMainBinding;
import com.example.healthcare.frag.Booking;
import com.example.healthcare.frag.HomeFragment;
import com.example.healthcare.frag.Notification;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CALL = 1;

    BottomNavigationView bottomNavigationView;


    Button btn;
    CardView micon;

    ImageView profile,logout;
    TextView user_email;
    ImageView profile2;
    public static final Integer RecordAudioRequestCode = 1;
    private SpeechRecognizer speechRecognizer;
    private EditText editText;
    private ImageView micButton;
    private TextToSpeech ttp;
    ActivityMainBinding binding;
    public String id;
    RelativeLayout topbar;
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    public void image_put(String image){
        SharedPreferences address= getSharedPreferences("address",MODE_PRIVATE);
        String address_=address.getString("addressi","");
        Glide.with(this).load(address_+image).into(profile);
        Glide.with(this).load(address_+image).into(profile2);
        Toast.makeText(this, image, Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getSupportActionBar().hide();
        Window window = getWindow();
        int colorCodeDark = Color.parseColor("#3FAA81");
        window.setStatusBarColor(colorCodeDark);
        //topbar.findViewById(R.id.topbar);




















        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());
        CardView pic=findViewById(R.id.profile);

        binding.bottomNavigationView.setBackground(null);
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.home:
                    pic.setVisibility(View.VISIBLE);
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.booking:
                    //topbar.setVisibility(View.GONE);
                    pic.setVisibility(View.GONE);
                    replaceFragment(new Booking());
                    break;
                case R.id.reminder:
                    //topbar.setVisibility(View.GONE);
                    pic.setVisibility(View.GONE);
                    replaceFragment(new Notification());
                    break;
                case R.id.location:
                    //topbar.setVisibility(View.GONE);
                    Intent intent=new Intent(getApplicationContext(),googlemaps.class);
                    startActivity(intent);
                    break;
            }

            return true;
        });

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomDialog();
            }
        });







        //micon = findViewById(R.id.micon);
        //micon.setVisibility(View.GONE);



        SharedPreferences address= getSharedPreferences("address",MODE_PRIVATE);
        String address_=address.getString("address","");

        //bottomNavigationView  = findViewById(R.id.bottom_navigation);

        //getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();


        user_email=findViewById(R.id.urname);
        nav=(NavigationView)findViewById(R.id.navmenu);
        View headerView = nav.getHeaderView(0);
        profile2=findViewById(R.id.profil);
        profile = headerView.findViewById(R.id.profil);
        SharedPreferences sharedPreferences= getSharedPreferences("login",MODE_PRIVATE);
        if (sharedPreferences.getString("logged","false").equals("false")){
            Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(intent);
            finish();
        }

        id=sharedPreferences.getString("id","");
        TextView balance_text = headerView.findViewById(R.id.balance);


        RequestQueue queue = Volley.newRequestQueue(this);
        String url =address_+"pic_profile.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            String status = jsonObject.getString("status");
                            if (status.equals("data fetched")){
                                String image=jsonObject.getString("image");
                                String balance=jsonObject.getString("balance");
                                String name=jsonObject.getString("firstname");
                                SharedPreferences.Editor editor=sharedPreferences.edit();
                                editor.putString("balance", balance);
                                editor.apply();
                                user_email.setText(name);
                                balance_text.setText(balance+" $");
                                image_put(image);

                            }
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
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
                return paramV;
            }
        };
        queue.add(stringRequest);


        //change name

        nav=(NavigationView)findViewById(R.id.navmenu);
        TextView fullname = headerView.findViewById(R.id.full);
        fullname.setText(sharedPreferences.getString("email",""));


        //end change name


        /*logout.setOnClickListener(new View.OnClickListener() {
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
        });*/

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), profile.class);
                startActivity(intent);
            }
        });
        profile2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), profile.class);
                startActivity(intent);
            }
        });







// side bar







        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setVisibility(View.GONE);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

        nav=(NavigationView)findViewById(R.id.navmenu);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);

        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.recent:
                        Intent intent = new Intent(getApplicationContext(), RecentActivity.class);
                        startActivity(intent);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.message:
                        Intent i = new Intent(getApplicationContext(), MessageActivity.class);
                        startActivity(i);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.exit:
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
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                        case R.id.add_balance:
                            Intent intent1=new Intent(getApplicationContext(),addBalance.class);
                            startActivity(intent1);
                            break;

                        case R.id.medical_pdf:
                            Intent intent2=new Intent(getApplicationContext(),PdfActivity.class);
                            startActivity(intent2);
                            break;
                }


                return true;
            }
        });

        //end of side bar code










        //micButton = findViewById(R.id.button);

        /*micButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP){
                    speechRecognizer.stopListening();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    micButton.setVisibility(View.GONE);
                    micon.setVisibility(View.VISIBLE);
                    speechRecognizer.startListening(speechRecognizerIntent);
                }
                return false;
            }
        });*/





    }

    private  void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

    private void showBottomDialog() {

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottomsheetlayout);

        LinearLayout videoLayout = dialog.findViewById(R.id.layoutVideo);
        LinearLayout shortsLayout = dialog.findViewById(R.id.layoutShorts);
        //LinearLayout liveLayout = dialog.findViewById(R.id.layoutLive);
        ImageView cancelButton = dialog.findViewById(R.id.cancelButton);

        videoLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(),Diagnose.class);
                startActivity(intent);

                dialog.dismiss();



            }
        });

        shortsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onmic(id);

                dialog.dismiss();

            }
        });

        /*liveLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
                Toast.makeText(MainActivity.this,"Go live is Clicked",Toast.LENGTH_SHORT).show();

            }
        });*/

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

    }

    private void checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.RECORD_AUDIO},RecordAudioRequestCode);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == RecordAudioRequestCode && grantResults.length > 0 ){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
                Toast.makeText(this,"Permission Granted",Toast.LENGTH_SHORT).show();
        }
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }

    }
    public void onmic(String id){
        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
        if (true){
            ttp=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int status) {
                    if(status != TextToSpeech.ERROR) {
                        ttp.setLanguage(Locale.UK);
                    }
                }
            });}else {
            ttp=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int status) {
                    if(status != TextToSpeech.ERROR) {
                        ttp.setLanguage(Locale.UK);
                    }
                }
            });

        }        if(ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED){
            checkPermission();
        }

        final Intent speechRecognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        if (false) {
            speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ar-dz");
        }else {
            speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        }
        speechRecognizer.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle bundle) {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }

            @Override
            public void onBeginningOfSpeech() {
                //editText.setText("");
                //editText.setHint("Listening...");

            }

            @Override
            public void onRmsChanged(float v) {

            }

            @Override
            public void onBufferReceived(byte[] bytes) {

            }

            @Override
            public void onEndOfSpeech() {

            }

            @Override
            public void onError(int i) {

            }

            @Override
            public void onResults(Bundle bundle) {
                SharedPreferences address= getSharedPreferences("address",MODE_PRIVATE);
                String address_=address.getString("address","");
                String url = address_+"ask.php";
                String urlweb = "https://en.wikipedia.org/wiki/";

                //micButton.setVisibility(View.VISIBLE);
                //micon.setVisibility(View.GONE);
                ArrayList<String> data = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                Toast.makeText(MainActivity.this, data.get(0), Toast.LENGTH_SHORT).show();
                if (data.get(0).contains("emergency")){
                    makePhoneCall();
                }
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                //Toast.makeText(MainActivity.this, data.get(0), Toast.LENGTH_SHORT).show();

                StringRequest strRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>()
                        {
                            @Override
                            public void onResponse(String response)
                            {
                                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(Intent.ACTION_VIEW);
                                i.setData(Uri.parse(urlweb+data.get(0)));
                                startActivity(i);
                                //editText.setText(response);
                                ttp.speak(response, TextToSpeech.QUEUE_FLUSH, null);
                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error)
                            {
                                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
                            }
                        })
                {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError
                    {
                        Map<String, String> datasent = new HashMap<String, String>();
                        datasent.put("id", id);
                        datasent.put("speech", data.get(0));
                        return datasent;
                    }
                };
// Add the JsonObjectRequest to the RequestQueue
                queue.add(strRequest);
            }
            @Override
            public void onPartialResults(Bundle bundle) {

            }
            @Override
            public void onEvent(int i, Bundle bundle) {

            }
        });
        speechRecognizer.startListening(speechRecognizerIntent);
        /*micButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP){
                    speechRecognizer.stopListening();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    micButton.setVisibility(View.GONE);
                    micon.setVisibility(View.VISIBLE);
                    speechRecognizer.startListening(speechRecognizerIntent);
                }
                return false;
            }
        });*/



    }
    private void makePhoneCall() {
        String number = "911";
        if (number.trim().length() > 0) {

            if (ContextCompat.checkSelfPermission(MainActivity.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }

        } else {
            Toast.makeText(MainActivity.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
        }
    }


    }


