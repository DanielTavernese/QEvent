package com.example.dan_t.mine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CardviewFood extends AppCompatActivity {

    private RecyclerView mFoodList;
    private AdapterJson mExampleAdapter;
    private ArrayList<EatingLocation> mFoodLists;
    private RequestQueue mRequestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardview);
        mFoodList=findViewById(R.id.myrecyclerview);
        mFoodList.setHasFixedSize(true);
        mFoodList.setLayoutManager(new LinearLayoutManager(this));

        mFoodLists = new ArrayList<>();
        mRequestQueue = Volley.newRequestQueue(this);
        parseJSON();
    }
    private void parseJSON(){
        String url = "https://husnain929.lib.id/Json-saving@dev/?Collection=event&field=Food";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            JSONArray array =response.getJSONObject(0).getJSONArray("Food");


                            for(int i=0; i < array.length();i++){


                                String Nonsplit = array.getString(i);

                                String[] parts = Nonsplit.split("/");
                                String part1 = parts[0]; // 004
                                String part2 = parts[1]; // 034556

                                String name = part1;
                                String location = part2;

                                //String location = Event.getString("address");
                                

                                mFoodLists.add(new EatingLocation(name, location));
                            }
                            mExampleAdapter = new AdapterJson(CardviewFood.this,mFoodLists);
                            mFoodList.setAdapter(mExampleAdapter);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mRequestQueue.add(request);
    }


}
