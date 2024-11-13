package com.example.healthcare.frag;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.healthcare.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import pl.droidsonroids.gif.GifImageView;
import com.example.healthcare.weatherData;

public class HomeFragment extends Fragment {
    Button btn;
    TextView bmiValue, bmiCategory, bmiTips;
    String category;
    String bmiValOutput;
    Button calculateAgainBtn;
    String[] bmiTipsArray;
    SharedPreferences sharedPreferences;
    String weight, height;
    double W, H;
    private Button button;

    final String APP_ID = "dab3af44de7d24ae7ff86549334e45bd";
    final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather";
    final long MIN_TIME = 5000;
    final float MIN_DISTANCE = 1000;
    final int REQUEST_CODE = 101;
    String Location_Provider = LocationManager.GPS_PROVIDER;
    TextView NameofCity, weatherState, Temperature, go_out;
    GifImageView mweatherIcon;
    RelativeLayout mCityFinder;
    LocationManager mLocationManager;
    LocationListener mLocationListener;
    String[] tips = {
            "Measure and Watch Your Weight\nKeeping track of your body weight on a daily or weekly basis will help you see what you’re losing and/or what you’re gaining.",
            "Limit Unhealthy Foods and Eat Healthy Meals\nDo not forget to eat breakfast and choose a nutritious meal with more protein and fiber and less fat, sugar, and calories.\n For more information on weight-control foods and dietary recommendations",
            "Take Multivitamin Supplements\nTo make sure you have sufficient levels of nutrients, taking a daily multivitamin supplement is a good idea, especially when you do not have a variety of vegetables and fruits at home. Many micronutrients are vital to your immune system, including vitamins A, B6, B12, C, D, and E, as well as zinc, iron, copper, selenium, and magnesium. However, there’s currently NO available evidence that adding any supplements or “miracle mineral supplements” to your diet will help protect you from the virus or increase recovery. In some cases, high doses of vitamins can be bad for your health.",
            "Drink Water and Stay Hydrated, and Limit Sugared Beverages\nDrink water regularly to stay healthy, but there is NO evidence that drinking water frequently.",
            "Exercise Regularly and Be Physically Active\nAt this time, at-home workouts may be a good idea. But you can also walk your dog or run outside. Be sure you know what’s going on in your area and if there are any restrictions or mandatory self-quarantines. For more information on how to stay physically active while at home, please check the ACSM website: www.acsm.org/read-research/newsroom/news-releases/news-detail/2020/03/16/staying-physically-active-during-covid-19-pandemic.",
            "Reduce Sitting and Screen Time\nExercise can’t immunize you from your sedentary time. Even people who exercise regularly could be at increased risk for diabetes and heart disease and stroke if they spend lots of time sitting behind computers. Practically speaking, you could consider taking breaks from sedentary time, such as walking around the office/room a couple of times in a day.",
            "Get Enough Good Sleep\nThere is a very strong connection between sleep quality and quantity and your immune system. You can keep your immune system functioning properly by getting seven to eight hours of sleep each night. For more information, please check the CDC website: www.cdc.gov/sleep/index.html.",
            "Go Easy on Alcohol and Stay Sober\nDrinking alcohol does not protect you from the coronavirus infection. Don’t forget that those alcohol calories can add up quickly. Alcohol should always be consumed in moderation. Please see the recommendations by the AHA: www.heart.org/en/healthy-living/healthy-eating/eat-smart/nutrition-basics/alcohol-and-heart-health.",
            "Find Ways to Manage Your Emotions\nIt is common for people to have feelings of fear, anxiety, sadness, and uncertainty during a pandemic. To minimize stress-related weight gain, you use this information about stress and coping provided by the CDC: www.cdc.gov/coronavirus/2019-ncov/prepare/managing-stress-anxiety.html.",
            "Use an App to Keep Track of Your Movement, Sleep, and Heart Rate"
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
        String id = sharedPreferences.getString("id", "");
        SharedPreferences address = getActivity().getSharedPreferences("address", Context.MODE_PRIVATE);
        String address_ = address.getString("address", "");

        Date date = Calendar.getInstance().getTime();
        weatherState = view.findViewById(R.id.weatherCondition);
        Temperature = view.findViewById(R.id.temperature);
        mweatherIcon = view.findViewById(R.id.weatherIcon);
        NameofCity = view.findViewById(R.id.cityName);
        go_out = view.findViewById(R.id.go_out);
        go_out.setVisibility(View.GONE);
        TextView tipss=view.findViewById(R.id.tips);

        Random random = new Random();
        int randomNumber = random.nextInt(10);
        tipss.setText(tips[randomNumber]);

        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
        String url = address_ + "bmi.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String status = jsonObject.getString("status");
                            if (status.equals("data fetched")) {
                                height = jsonObject.getString("height");
                                weight = jsonObject.getString("weight");
                                H = Double.parseDouble(height);
                                W = Double.parseDouble(weight);
                                 // Replace with the height in meters

                                // Calculate the minimum weight
                                DecimalFormat df = new DecimalFormat("0.00");
                                double minWeight =  18.5 * (H/100 * H/100);
                                minWeight= Double.parseDouble(df.format(minWeight));

                                // Calculate the maximum weight
                                double maxWeight = 24.9 * (H/100 * H/100);
                                maxWeight= Double.parseDouble(df.format(maxWeight));

                                TextView bmi_rate=view.findViewById(R.id.bmi_rate);
                                bmi_rate.setText("Your weight should be between:"+  minWeight+"-"+maxWeight);
                                double bmi = calculateBmi();
                                bmiValOutput = df.format(bmi);
                                bmiValue.setText(bmiValOutput);
                                Toast.makeText(getActivity().getApplicationContext(), bmiValOutput, Toast.LENGTH_SHORT).show();
                                findCategory();
                                categoryTips();
                            }
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Handle error
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> paramV = new HashMap<>();
                paramV.put("id", id);
                return paramV;
            }
        };
        queue.add(stringRequest);

        bmiValue = view.findViewById(R.id.bmi_value);
        bmiCategory = view.findViewById(R.id.bmi_category);
        bmiTips = view.findViewById(R.id.bmi_tips);
        bmiTipsArray = getResources().getStringArray(R.array.tips_array);

        return view;
    }

    private void categoryTips() {
        double result = Double.parseDouble(bmiValOutput);
        if (result < 15) {
            bmiTips.setText(bmiTipsArray[0]);
            bmiValue.setTextColor(getResources().getColor(R.color.red));
            bmiTips.setTextColor(getResources().getColor(R.color.orange));
        } else if (result >= 15 && result <= 16) {
            bmiTips.setText(bmiTipsArray[0]);
            bmiValue.setTextColor(getResources().getColor(R.color.red));
            bmiTips.setTextColor(getResources().getColor(R.color.orange));
        } else if (result >= 16 && result <= 18.5) {
            bmiTips.setText(bmiTipsArray[1]);
            bmiValue.setTextColor(getResources().getColor(R.color.orange));
        } else if (result >= 18.5 && result <= 25) {
            bmiTips.setText(bmiTipsArray[2]);
            bmiValue.setTextColor(getResources().getColor(R.color.green));
        } else if (result >= 25 && result <= 30) {
            bmiTips.setText(bmiTipsArray[3]);
            bmiValue.setTextColor(getResources().getColor(R.color.green));
        } else if (result >= 30 && result <= 35) {
            bmiTips.setText(bmiTipsArray[4]);
            bmiValue.setTextColor(getResources().getColor(R.color.orange));
        } else if (result >= 35 && result <= 50) {
            bmiTips.setText(bmiTipsArray[4]);
            bmiValue.setTextColor(getResources().getColor(R.color.red));
            bmiTips.setTextColor(getResources().getColor(R.color.orange));
        } else {
            bmiTips.setText(bmiTipsArray[4]);
        }
    }

    private void findCategory() {
        double result = Double.parseDouble(bmiValOutput);
        if (result < 15) {
            category = "Very Severely Underweight";
            bmiCategory.setText(category);
        } else if (result >= 15 && result <= 16) {
            category = "Severely Underweight";
            bmiCategory.setText(category);
        } else if (result >= 16 && result <= 18.5) {
            category = "Underweight";
            bmiCategory.setText(category);
        } else if (result >= 18.5 && result <= 25) {
            category = "Normal (Healthy weight)";
            bmiCategory.setText(category);
        } else if (result >= 25 && result <= 30) {
            category = "Overweight";
            bmiCategory.setText(category);
        } else if (result >= 30 && result <= 35) {
            category = "Moderately Obese";
            bmiCategory.setText(category);
        } else if (result >= 35 && result <= 50) {
            category = "Severely Obese";
            bmiCategory.setText(category);
        } else {
            category = "Very Severely Obese";
            bmiCategory.setText(category);
        }
    }

    public double calculateBmi() {
        double heightInMetres = H / 100;
        double heightInMetreSq = heightInMetres * heightInMetres;
        double bmi = W / heightInMetreSq;
        return bmi;
    }

    @Override
    public void onResume() {
        super.onResume();
        Intent mIntent = getActivity().getIntent();
        String city = mIntent.getStringExtra("City");
        if (city != null) {
            getWeatherForNewCity(city);
        } else {
            getWeatherForCurrentLocation();
        }
    }

    private void getWeatherForNewCity(String city) {
        RequestParams params = new RequestParams();
        params.put("q", city);
        params.put("appid", APP_ID);
        letsdoSomeNetworking(params);
    }

    private void getWeatherForCurrentLocation() {
        mLocationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        mLocationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                String latitude = String.valueOf(location.getLatitude());
                String longitude = String.valueOf(location.getLongitude());

                RequestParams params = new RequestParams();
                params.put("lat", latitude);
                params.put("lon", longitude);
                params.put("appid", APP_ID);
                letsdoSomeNetworking(params);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {}

            @Override
            public void onProviderEnabled(String provider) {}

            @Override
            public void onProviderDisabled(String provider) {}
        };

        if (ActivityCompat.checkSelfPermission(getActivity().getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(getActivity().getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
            return;
        }

        mLocationManager.requestLocationUpdates(Location_Provider, MIN_TIME, MIN_DISTANCE, mLocationListener);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getActivity().getApplicationContext(), "Location successfully obtained", Toast.LENGTH_SHORT).show();
                getWeatherForCurrentLocation();
            } else {
                // User denied the permission
            }
        }
    }

    private void letsdoSomeNetworking(RequestParams params) {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(WEATHER_URL, params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                //Toast.makeText(getActivity().getApplicationContext(), "Weather updated", Toast.LENGTH_SHORT).show();
                weatherData weather = weatherData.fromJson(response);
                updateUI(weather);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                // Handle failure
            }
        });
    }

    private void updateUI(weatherData weather) {
        String temp_string = weather.getmTemperature().substring(0, 2);
        int temp = Integer.parseInt(temp_string);

        if (temp < 7) {
            go_out.setVisibility(View.VISIBLE);
            go_out.setText("I recommend wearing a coat before going out, it's too cold");
        }

        Temperature.setText(weather.getmTemperature());
        NameofCity.setText(weather.getMcity());
        weatherState.setText(weather.getmWeatherType());

        int resourceID = getResources().getIdentifier(weather.getMicon(), "drawable", getActivity().getPackageName());
        mweatherIcon.setImageResource(resourceID);
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mLocationManager != null) {
            mLocationManager.removeUpdates(mLocationListener);
        }
    }
}
