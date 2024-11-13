package com.example.healthcare;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.healthcare.messages.AdapterMessage;
import com.example.healthcare.messages.MesageModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MessageActivity extends AppCompatActivity {

        private RecyclerView courseRV;

        // variable for our adapter
        // class and array list
        private AdapterMessage adapter;
        private ArrayList<MesageModel> courseModalArrayList;

        // below line is the variable for url from
        // where we will be querying our data.
        String url ;
        private ProgressBar progressBar;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_message);
            SharedPreferences address= getSharedPreferences("address",MODE_PRIVATE);
            String address_=address.getString("address","");
            SharedPreferences sharedPreferences= getSharedPreferences("login",MODE_PRIVATE);
            String id=sharedPreferences.getString("id","");


            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Messages");

            url = address_+"message.php";

            // initializing our variables.
            courseRV = findViewById(R.id.idRVCourses);
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
            RequestQueue queue = Volley.newRequestQueue(MessageActivity.this);
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
                                String courseName = responseObj.getString("phone");
                                String courseTracks = responseObj.getString("message");
                                String courseMode = responseObj.getString("name");
                                String courseImageURL = responseObj.getString("time");
                                courseModalArrayList.add(new MesageModel(courseName, courseImageURL, courseMode, courseTracks));
                                buildRecyclerView();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(MessageActivity.this, "Fail to get the data..", Toast.LENGTH_SHORT).show();
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError
                {
                    Map<String, String> datasent = new HashMap<String, String>();
                    datasent.put("id", id);
                    return datasent;
                }
            };
            queue.add(jsonArrayRequest);
        }

        private void buildRecyclerView() {

            // initializing our adapter class.
            adapter = new AdapterMessage(courseModalArrayList, MessageActivity.this);

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
    }
