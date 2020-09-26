package com.example.statewise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    public static List<Model> modelList = new ArrayList<>();
    Model model;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        fetchData();

    }

    private void fetchData() {

        String url = "https://api.covid19india.org/state_district_wise.json"; //The Link Through Which We Can Fetch Data

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject object = new JSONObject(response);   //Creating JSON Object
                    JSONObject object1 = object.getJSONObject("Uttar Pradesh");//From that object we are fetching data
                    JSONObject object2 = object1.getJSONObject("districtData");
                    JSONObject object3 = object2.getJSONObject("Prayagraj");
                    JSONObject object4 = object3.getJSONObject("delta");


                    String active = object3.getString("active");
                    String confirmed = object3.getString("confirmed");
                    String deceased = object3.getString("deceased");
                    String recovered = object3.getString("recovered");

                    String confInc = object4.getString("confirmed");
                    String confDec = object4.getString("deceased");
                    String confRec = object4.getString("recovered");

                    model = new Model("Prayagraj",confirmed,deceased,recovered,active,confInc,confDec,confRec);
                    modelList.add(model);//placing data into the app using AdapterClass

                    object3 = object2.getJSONObject("Ballia");//Creating JSON Object
                    active = object3.getString("active");//From that object we are fetching data
                    confirmed = object3.getString("confirmed");
                    deceased = object3.getString("deceased");
                    recovered = object3.getString("recovered");
                    object4 = object3.getJSONObject("delta");

                    confInc = object4.getString("confirmed");
                    confDec = object4.getString("deceased");
                    confRec = object4.getString("recovered");

                    model = new Model("Ballia",confirmed,deceased,recovered,active,confInc,confDec,confRec);
                    modelList.add(model);//placing data into the app using AdapterClass

                    object3 = object2.getJSONObject("Lucknow");//Creating JSON Object
                    active = object3.getString("active");//From that object we are fetching data
                    confirmed = object3.getString("confirmed");
                    deceased = object3.getString("deceased");
                    recovered = object3.getString("recovered");
                    object4 = object3.getJSONObject("delta");

                    confInc = object4.getString("confirmed");
                    confDec = object4.getString("deceased");
                    confRec = object4.getString("recovered");

                    model = new Model("Lucknow",confirmed,deceased,recovered,active,confInc,confDec,confRec);
                    modelList.add(model);//placing data into the app using AdapterClass

                    object3 = object2.getJSONObject("Varanasi");//Creating JSON Object
                    active = object3.getString("active");//From that object we are fetching data
                    confirmed = object3.getString("confirmed");
                    deceased = object3.getString("deceased");
                    recovered = object3.getString("recovered");
                    object4 = object3.getJSONObject("delta");

                    confInc = object4.getString("confirmed");
                    confDec = object4.getString("deceased");
                    confRec = object4.getString("recovered");

                    model = new Model("Varanasi",confirmed,deceased,recovered,active,confInc,confDec,confRec);
                    modelList.add(model);//placing data into the app using AdapterClass

                    object3 = object2.getJSONObject("Agra");//Creating JSON Object
                    active = object3.getString("active");//From that object we are fetching data
                    confirmed = object3.getString("confirmed");
                    deceased = object3.getString("deceased");
                    recovered = object3.getString("recovered");
                    object4 = object3.getJSONObject("delta");

                    confInc = object4.getString("confirmed");
                    confDec = object4.getString("deceased");
                    confRec = object4.getString("recovered");

                    model = new Model("Agra",confirmed,deceased,recovered,active,confInc,confDec,confRec);
                    modelList.add(model);//placing data into the app using AdapterClass

                    adapter = new Adapter(MainActivity.this,modelList);
                    listView.setAdapter(adapter);

                } catch (JSONException e) { //In case of error it will run
                    e.printStackTrace();

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) { //In case of error it will run

                Toast.makeText(MainActivity.this,error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);

    }

}