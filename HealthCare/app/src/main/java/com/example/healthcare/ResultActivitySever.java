package com.example.healthcare;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ResultActivitySever extends AppCompatActivity {
    private TextView illnessT;
    private TextView treatmentT,what;
    private TextToSpeech ttp;
    ImageView play,stop,map;
    Locale ttpl;
    String url;
    private SpeechRecognizer speechRecognizer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_sever);

        illnessT=findViewById(R.id.illness);
        treatmentT=findViewById(R.id.treatment);
        play=findViewById(R.id.play);
        stop=findViewById(R.id.stop);
        map=findViewById(R.id.map);
        what=findViewById(R.id.whatshouldyoudo);
        //url =  "http://192.168.1.6:80/si/helpEN.php";


        Bundle extras = getIntent().getExtras();

        String illness = extras.getString("illness");
        String treatment = extras.getString("treatment");
        String image = extras.getString("image");
        String language=extras.getString("language");

        SharedPreferences address= getSharedPreferences("address",MODE_PRIVATE);
        String address_=address.getString("addressi","");
        ImageView image_pic=findViewById(R.id.image);
        Glide.with(this).load(address_+"illness/"+image).into(image_pic);

        ImageView wiki=findViewById(R.id.wiki);
        wiki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wikip(illness);
            }
        });


        if(language.equals("ar")){
            what.setText("ماذا عليك ان تفعل؟");

            //url = "http://192.168.1.6:80/si/returnresponseAR.php";


            //language=;
        } else if (language.equals("en")) {
            what.setText("What should you do?");

        }else if (language.equals("fr")){
            what.setText("Que devrais tu faire?");
        }


        ttp=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    if(language.equals("ar")){
                        ttp.setLanguage(new Locale("ar"));
                    } else if (language.equals("en")) {
                        ttp.setLanguage(Locale.UK);
                    }else if (language.equals("fr")){
                        ttp.setLanguage(Locale.FRANCE);
                    }
                }
            }
        });

        illnessT.setText(illness);
        treatmentT.setText(treatment);
        //ttp.speak(illness+" "+treatment, TextToSpeech.QUEUE_FLUSH, null);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                play.setImageResource(R.drawable.play_on);
                if(language.equals("ar")){
                    ttp.speak("من المحتمل أن يكون لديك:" + illness + "يجب عليك الذهاب إلى المستشفى أو الطبيب المختص والقيام بما يلي" + treatment, TextToSpeech.QUEUE_FLUSH, null);

                    //url = "http://192.168.1.6:80/si/returnresponseAR.php";


                    //language=
                } else if (language.equals("en")) {
                    ttp.speak("You probably have:"+illness+"You must go to the hostpital or a specialised doctor and do the following:" +treatment, TextToSpeech.QUEUE_FLUSH, null);

                }else if (language.equals("fr")){
                    ttp.speak("Vous avez probablement :"+illness+"Vous pouvez vous rendre à la pharmacie pour vous faire soigner et faire ce qui suit" +treatment, TextToSpeech.QUEUE_FLUSH, null);

                }

            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ttp.stop();
                play.setImageResource(R.drawable.play);
            }
        });
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), mapshospital.class);
                startActivity(i);
                //Toast.makeText(ResultActivityLight.this, "map", Toast.LENGTH_SHORT).show();
                //ttp.speak(illness+" "+treatment, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }
    public void wikip(String ilness){
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

        }

        final Intent speechRecognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        if (false) {
            speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ar-dz");
        }else {
            speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        }
        SharedPreferences address= getSharedPreferences("address",MODE_PRIVATE);
        String address_=address.getString("address","");
        String url = address_+"ask.php";
        String urlweb = "https://en.wikipedia.org/wiki/";

        //micButton.setVisibility(View.VISIBLE);
        //micon.setVisibility(View.GONE);
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        //Toast.makeText(MainActivity.this, data.get(0), Toast.LENGTH_SHORT).show();

        StringRequest strRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(urlweb+ilness));
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
                datasent.put("id", "1");
                datasent.put("speech", ilness);
                return datasent;
            }
        };
// Add the JsonObjectRequest to the RequestQueue
        queue.add(strRequest);
    }
}