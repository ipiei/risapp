package com.example.riscrossfit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.riscrossfit.models.Evenement;
import com.example.riscrossfit.outilHttp.EvenementAdapter;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class EvenementActivity extends AppCompatActivity {

    RecyclerView eventView;
    ArrayList<Evenement> listEvenement;
    private com.example.riscrossfit.outilHttp.EvenementAdapter EvenementAdapter;
    private String url = "http://192.168.43.17:88/LoginRegisterAndroid/SelectEvenement.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evenement);

        listEvenement = new ArrayList<>();

        eventView = findViewById(R.id.evenementView);

        EvenementAdapter = new EvenementAdapter(listEvenement);
        eventView.setAdapter(EvenementAdapter);
        eventView.setLayoutManager(new LinearLayoutManager(this));
        getData();
    }




    public void getData(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        Log.i("responseVelib", "ok");
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.i("ResponseR: " , response.getJSONArray("resultEvenement").get(0).toString());
                            JSONArray jsonArray = response.getJSONArray("resultEvenement");
                            for(int i = 0; i < jsonArray.length(); i++){
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                Log.i("Response: ", jsonObject.getString("evenement"));
                                Gson gson = new Gson();
                                Evenement fields = gson.fromJson(jsonObject.getString("evenement"), Evenement.class);
                                Log.i("Response: ", fields.getTitre());
                                listEvenement.add(fields);

                            }
                            EvenementAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });
        requestQueue.add(jsonObjectRequest);

    }



}