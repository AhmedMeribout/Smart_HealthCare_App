package com.example.healthcare.frag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.healthcare.R;
import com.example.healthcare.doctor_profile;
import com.example.healthcare.doctors.AdapterDoctor;
import com.example.healthcare.doctors.DoctorModel;
import com.example.healthcare.doctors.SelectDoctorListener;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.content.Intent;


public class Booking extends Fragment implements SelectDoctorListener {
    private RecyclerView courseRV;

    // variable for our adapter
    // class and array list
    private AdapterDoctor adapter;
    private ArrayList<DoctorModel> courseModalArrayList;

    // below line is the variable for url from
    // where we will be querying our data.
    String url ;
    private ProgressBar progressBar;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_notification, container, false);

        SharedPreferences address= getActivity().getSharedPreferences("address",getActivity().MODE_PRIVATE);
        String address_=address.getString("address","");
        SharedPreferences sharedPreferences= getActivity().getSharedPreferences("login",getActivity().MODE_PRIVATE);
        String id=sharedPreferences.getString("id","");


        url = address_+"doctor.php";

        // initializing our variables.
        courseRV = view.findViewById(R.id.idRVCourses);
        progressBar = view.findViewById(R.id.idPB);

        // below line we are creating a new array list
        courseModalArrayList = new ArrayList<>();
        getData(id);

        // calling method to
        // build recycler view.
        //buildRecyclerView();
        

        return view;
    }

    private void getData(String id) {
        // creating a new variable for our request queue
        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
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
                            String courseName = responseObj.getString("name");
                            String courseTracks = responseObj.getString("speciality");
                            String courseMode = responseObj.getString("id");
                            String courseImageURL = responseObj.getString("phone");
                            courseModalArrayList.add(new DoctorModel(courseName, courseImageURL, courseMode, courseTracks));
                            buildRecyclerView();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (JSONException e) {
                    Toast.makeText(getActivity().getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity().getApplicationContext(), "Fail to get the data..", Toast.LENGTH_SHORT).show();
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
        adapter = new AdapterDoctor(courseModalArrayList, getActivity().getApplicationContext(),this);

        // adding layout manager
        // to our recycler view.
        LinearLayoutManager manager = new LinearLayoutManager(getActivity().getApplicationContext());
        courseRV.setHasFixedSize(true);

        // setting layout manager
        // to our recycler view.
        courseRV.setLayoutManager(manager);

        // setting adapter to
        // our recycler view.
        courseRV.setAdapter(adapter);
    }



    @Override
    public void onDoctorClicked(DoctorModel mymodel) {
        Intent intent=new Intent(getActivity().getApplicationContext(), doctor_profile.class);
        intent.putExtra("doctor_id", mymodel.getSpeech());
        //put extra mymodel.getSpeech()
        startActivity(intent);
        //Toast.makeText(getActivity().getApplicationContext(), mymodel.getSpeech(), Toast.LENGTH_SHORT).show();

    }
}
