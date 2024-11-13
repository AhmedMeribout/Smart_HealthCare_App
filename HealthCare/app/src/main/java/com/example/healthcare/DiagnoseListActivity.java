package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.healthcare.diagnose.DiagnoseAdaptater;
import com.example.healthcare.diagnose.DiagnoseListner;
import com.example.healthcare.diagnose.DiagnoseModel;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DiagnoseListActivity extends AppCompatActivity implements DiagnoseListner {

    private RecyclerView courseRV;
    TextView test;

    // variable for our adapter
    // class and array list
    private DiagnoseAdaptater adapter;
    private ArrayList<DiagnoseModel> courseModalArrayList;

    // below line is the variable for url from
    // where we will be querying our data.
    String url ;
    private ProgressBar progressBar;
    String speech;
    TextToSpeech ttp;
    String language;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnose_list);
        SharedPreferences address= getSharedPreferences("address",MODE_PRIVATE);
        String address_=address.getString("address","");
        SharedPreferences sharedPreferences= getSharedPreferences("login",MODE_PRIVATE);
        String id=sharedPreferences.getString("id","");

        Bundle extras = getIntent().getExtras();

        speech = extras.getString("speech");
        language = extras.getString("language");
        url = address_+"diagnoselist.php";

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






        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Diagnose List");




        // initializing our variables.
        courseRV = findViewById(R.id.idRVCourses);
        test=findViewById(R.id.test);
        progressBar = findViewById(R.id.idPB);

        // below line we are creating a new array list
        courseModalArrayList = new ArrayList<>();
        getData(id);

        // calling method to
        // build recycler view.
        buildRecyclerView();
    }

    private void getData(String id) {
        // creating a new variable for our request queue
        RequestQueue queue = Volley.newRequestQueue(DiagnoseListActivity.this);
        // in this case the data we are getting is in the form
        // of array so we are making a json array request.
        // below is the line where we are making an json array
        // request and then extracting data from each json object.
        StringRequest jsonArrayRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressBar.setVisibility(View.GONE);
                courseRV.setVisibility(View.VISIBLE);
                try {
                    JSONArray jsonArrayResult = new JSONArray(response);
                    for (int i = 0; i < jsonArrayResult.length(); i++) {
                        // creating a new json object and
                        // getting each object from our json array.
                        try {
                            // we are getting each json object.
                            JSONObject responseObj = jsonArrayResult.getJSONObject(i);

                            // now we get our response from API in json object format.
                            // in below line we are extracting a string with
                            // its key value from our json object.
                            // similarly we are extracting all the strings from our json object.
                            String courseName = responseObj.getString("symptomen");
                            String courseTracks = responseObj.getString("treatmenten");
                            String courseMode = responseObj.getString("photo");
                            String courseImageURL = responseObj.getString("symptom_id");
                            courseModalArrayList.add(new DiagnoseModel(courseName, courseImageURL, courseMode, courseTracks));

                            buildRecyclerView();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (JSONException e) {
                    Toast.makeText(DiagnoseListActivity.this, speech, Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(DiagnoseListActivity.this, DoctorActivity.class);
                    startActivity(i);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //test.setText(error.toString());


                Toast.makeText(DiagnoseListActivity.this, "No solution found", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {
                Map<String, String> datasent = new HashMap<String, String>();
                datasent.put("speech", speech);
                return datasent;
            }
        };
        queue.add(jsonArrayRequest);
    }

    private void buildRecyclerView() {

        // initializing our adapter class.
        adapter = new DiagnoseAdaptater(courseModalArrayList, DiagnoseListActivity.this,this);

        // adding layout manager
        // to our recycler view.
        LinearLayoutManager manager = new LinearLayoutManager(this);
        courseRV.setHasFixedSize(true);

        // setting layout manager
        // to our recycler view.
        courseRV.setLayoutManager(manager);

        // setting adapter to
        // our recycler view.
        courseRV.setAdapter(adapter);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDiagnoseClicked(DiagnoseModel dModel) {


        ttp.speak(dModel.getResponse(), TextToSpeech.QUEUE_FLUSH, null);

    }
}