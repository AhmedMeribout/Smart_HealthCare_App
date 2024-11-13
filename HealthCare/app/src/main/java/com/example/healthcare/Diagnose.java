package com.example.healthcare;

import android.Manifest;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
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

import org.apache.commons.text.StringEscapeUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


public class Diagnose extends AppCompatActivity {
    Button logoutbutton,profile,recentbutton;
    TextView user_email;

    public static final Integer RecordAudioRequestCode = 1;
    private SpeechRecognizer speechRecognizer;
    Button pdfbutton,doctors;
    String decodedResponse;
    private EditText editText;
    private ImageView micButton;
    private TextToSpeech ttp;
    ImageButton bOpenAlertDialog;
    String language,deletekeyword,diagnosekeyword,url;

    private View backgroundView;
    private AnimatorSet colorAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnos);

        bOpenAlertDialog = findViewById(R.id.openAlertDialogButton);
        final Intent speechRecognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

        SharedPreferences address= getSharedPreferences("address",MODE_PRIVATE);
        String address_=address.getString("address","");

        backgroundView = findViewById(R.id.background); // Replace with your view ID




        int[] checkedItem = {-1};
        language="en";
        deletekeyword="delete";
        diagnosekeyword="diagnose me";
        url = address_+"returnresponseEN.php";

        bOpenAlertDialog.setOnClickListener(v -> {
            // AlertDialog builder instance to build the alert dialog
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(Diagnose.this);

            // set the custom icon to the alert dialog
            alertDialog.setIcon(R.drawable.languages);

            // title of the alert dialog
            alertDialog.setTitle("Choose the language");

            // list of the items to be displayed to the user in the
            // form of list so that user can select the item from
            final String[] listItems = new String[]{"Arabic", "English", "French"};

            // the function setSingleChoiceItems is the function which
            // builds the alert dialog with the single item selection
            alertDialog.setSingleChoiceItems(listItems, checkedItem[0], (dialog, which) -> {
                // update the selected item which is selected by the user so that it should be selected
                // when user opens the dialog next time and pass the instance to setSingleChoiceItems method
                checkedItem[0] = which;

                if(listItems[which].equals("Arabic")){
                    //final Intent speechRecognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                    // speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                    //speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ar-AR");
                    speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ar-AR");
                    deletekeyword="امسح";
                    diagnosekeyword="شخصني";
                    url = address_+"returnresponseAR.php";
                    language="ar";


                    //language=;
                } else if (listItems[which].equals("English")) {
                    speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-GB");
                    deletekeyword="delete";
                    diagnosekeyword="diagnose me";
                    url = address_+"returnresponseEN.php";
                    language="en";

                }else if (listItems[which].equals("French")){
                    speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "fr-FR");
                    deletekeyword="efface";
                    diagnosekeyword="diagnostic";
                    url = address_+"returnresponseFR.php";
                    language="fr";
                }

                dialog.dismiss();
            });

            // set the negative button if the user is not interested to select or change already selected item
            alertDialog.setNegativeButton("Cancel", (dialog, which) -> {

            });

            // create and build the AlertDialog instance with the AlertDialog builder instance
            AlertDialog customAlertDialog = alertDialog.create();

            // show the alert dialog when the button is clicked
            customAlertDialog.show();
        });



        editText = findViewById(R.id.text);
        micButton = findViewById(R.id.button);
        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);





        SharedPreferences sharedPreferences= getSharedPreferences("login",MODE_PRIVATE);
        if (sharedPreferences.getString("logged","false").equals("false")){
            Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(intent);
            finish();
        }
        String id=sharedPreferences.getString("id","");

        ttp=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    ttp.setLanguage(Locale.UK);
                }
            }
        });
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED){
            checkPermission();
        }


        speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);


        speechRecognizer.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle bundle) {

            }

            @Override
            public void onBeginningOfSpeech() {
                //editText.setText("");
                editText.setHint("Listening...");
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
                micButton.setImageResource(R.drawable.healthcare);
                ArrayList<String> data = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                if(data.get(0).equals(deletekeyword)){
                    editText.setText("");
                } else if (data.get(0).equals(diagnosekeyword)) {
                    String text = editText.getText().toString();
                    editText.setText(text.substring(0, text.length() - 1));
                    editText.append(".");
                    RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                    //Toast.makeText(MainActivity.this, data.get(0), Toast.LENGTH_SHORT).show();

                    StringRequest strRequest = new StringRequest(Request.Method.POST, url,
                            new Response.Listener<String>()
                            {
                                @Override
                                public void onResponse(String response)
                                {
                                    //Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                                    if(language.equals("fr")){
                                        decodedResponse = StringEscapeUtils.unescapeJava(response);

                                        try {
                                            JSONObject jsonObject = new JSONObject(decodedResponse);
                                            //JSONObject jsonObject=new JSONObject(decodedResponse);
                                            String level= jsonObject.getString("level");

                                            String treatment = jsonObject.getString("treatment");
                                            String illness= jsonObject.getString("illness");
                                            String image= jsonObject.getString("images");
                                            editText.setText(level);
                                            if(level.equals("1")){
                                                Intent i = new Intent(Diagnose.this, ResultActivityLight.class);
                                                i.putExtra("illness",illness);
                                                i.putExtra("language",language);
                                                i.putExtra("image",image);
                                                i.putExtra("treatment",treatment);
                                                startActivity(i);

                                            } else if (level.equals("2")) {
                                                //editText.setText(response);
                                                Intent i = new Intent(Diagnose.this, ResultActivitySever.class);
                                                i.putExtra("illness",illness);
                                                i.putExtra("language",language);
                                                i.putExtra("image",image);
                                                i.putExtra("treatment",treatment);
                                                startActivity(i);

                                            }
                                        } catch (JSONException e) {
                                            //editText.setText(response);
                                            if(response.toString().contains("error")){
                                                //editText.setText(response);
                                                Toast.makeText(Diagnose.this, response, Toast.LENGTH_SHORT).show();
                                            }else if (response.toString().contains("fund")) {
                                                Intent i = new Intent(Diagnose.this, addBalance.class);
                                                startActivity(i);
                                            }else {
                                                Intent i = new Intent(Diagnose.this, DiagnoseListActivity.class);
                                                i.putExtra("speech",editText.getText().toString());
                                                i.putExtra("language",language);
                                                startActivity(i);



                                            }
                                            editText.setText(decodedResponse);





                                            //throw new RuntimeException(e);
                                        }

                                    }else{
                                        try {
                                            JSONObject jsonObject = new JSONObject(response);
                                            //JSONObject jsonObject=new JSONObject(decodedResponse);
                                            String level= jsonObject.getString("level");

                                            String treatment = jsonObject.getString("treatment");
                                            String illness= jsonObject.getString("illness");
                                            String image= jsonObject.getString("images");
                                            editText.setText(level);
                                            if(level.equals("1")){
                                                Intent i = new Intent(Diagnose.this, ResultActivityLight.class);
                                                i.putExtra("illness",illness);
                                                i.putExtra("language",language);
                                                i.putExtra("image",image);
                                                i.putExtra("treatment",treatment);
                                                startActivity(i);

                                            } else if (level.equals("2")) {
                                                //editText.setText(response);
                                                Intent i = new Intent(Diagnose.this, ResultActivitySever.class);
                                                i.putExtra("illness",illness);
                                                i.putExtra("language",language);
                                                i.putExtra("image",image);
                                                i.putExtra("treatment",treatment);
                                                startActivity(i);

                                            }
                                        } catch (JSONException e) {
                                            if(response.toString().contains("error")){
                                                //editText.setText(response);
                                                Toast.makeText(Diagnose.this, response, Toast.LENGTH_SHORT).show();
                                            }else if (response.toString().contains("fund")) {
                                                Intent i = new Intent(Diagnose.this, addBalance.class);
                                                startActivity(i);


                                            }else {
                                                Intent i = new Intent(Diagnose.this, DiagnoseListActivity.class);
                                                i.putExtra("speech",editText.getText().toString());
                                                i.putExtra("language",language);
                                                startActivity(i);



                                            }
                                            //editText.setText(decodedResponse);





                                            //throw new RuntimeException(e);
                                        }
                                    }



                                    editText.setText(response);
                                    //ttp.speak(response, TextToSpeech.QUEUE_FLUSH, null);
                                }
                            },
                            new Response.ErrorListener()
                            {
                                @Override
                                public void onErrorResponse(VolleyError error)
                                {

                                    editText.setText(error.toString());
                                    Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
                                }
                            })
                    {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError
                        {
                            Map<String, String> datasent = new HashMap<String, String>();
                            datasent.put("id", id);
                            datasent.put("speech", editText.getText().toString());
                            return datasent;
                        }
                    };
// Add the JsonObjectRequest to the RequestQueue
                    queue.add(strRequest);
                }else{
                    editText.append(data.get(0)+",");
                }


            }
            @Override
            public void onPartialResults(Bundle bundle) {

            }
            @Override
            public void onEvent(int i, Bundle bundle) {

            }
        });

        micButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP){
                    speechRecognizer.stopListening();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    micButton.setImageResource(R.drawable.mic_on);
                    speechRecognizer.startListening(speechRecognizerIntent);
                }
                return false;
            }
        });

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        speechRecognizer.destroy();
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

    }

}