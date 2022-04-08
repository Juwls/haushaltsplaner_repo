package com.example.ha_pla;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Einkaufen extends Activity {

    private RecyclerView rVEinkaufenListe;
    private final String URL = "http://10.0.2.2/android/einkaufenAdd.php";
    ArrayList<EinkaufenData> einkaufsliste = new ArrayList<>();
    private Button btnEinkaufHinzufuegen;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.einkaufen_layout);

        rVEinkaufenListe = findViewById(R.id.rVEinkaufenListe);
        rVEinkaufenListe.setHasFixedSize(true);
        rVEinkaufenListe.setLayoutManager(new LinearLayoutManager(this));
        einkaufsliste = new ArrayList<>();

        ladeEinkaufslisteVonDb();

    }


    public void speicherEinkaufsobjekt(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                response -> {
                    try {
                        JSONArray array = new JSONArray(response);

                        for (int i = 0; i < array.length(); i++) {

                            JSONObject einkaufsobjekt = array.getJSONObject(i);

                            ///remove toast before merging to main///////////////////////////////////////
                            //// https://stackoverflow.com/questions/7634518/getting-jsonobject-from-jsonarray
                            Toast.makeText(Einkaufen.this, einkaufsobjekt.toString(), Toast.LENGTH_SHORT).show();
                            ///////////////////////////////////////////////////////////

                            einkaufsliste.add(new EinkaufenData(
                                    einkaufsobjekt.getString("einkaufsobjekt")
                            ));
                        }

                        Einkaufen_RecyclerViewAdapter adapter = new Einkaufen_RecyclerViewAdapter(Einkaufen.this, einkaufsliste);
                        rVEinkaufenListe.setAdapter(adapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }, error -> {
            Toast.makeText(Einkaufen.this, error.toString().trim(), Toast.LENGTH_SHORT).show();
        });

        /*
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
        */

        Volley.newRequestQueue(this).add(stringRequest);

    }

    private void ladeEinkaufslisteVonDb(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL,
            response -> {
                try {
                    JSONArray array = new JSONArray(response);
                    // TODO: identify haushalt of array and match to haushalt which was selected by the user
                    for (int i = 0; i < array.length(); i++) {

                        JSONObject einkaufsobjekt = array.getJSONObject(i);

                        ///remove toast before merging to main///////////////////////////////////////
                        //// https://stackoverflow.com/questions/7634518/getting-jsonobject-from-jsonarray
                        Toast.makeText(Einkaufen.this, einkaufsobjekt.toString(), Toast.LENGTH_SHORT).show();
                        ///////////////////////////////////////////////////////////

                        einkaufsliste.add(new EinkaufenData(
                                einkaufsobjekt.getString("einkaufsobjekt")
                        ));
                    }

                    Einkaufen_RecyclerViewAdapter adapter = new Einkaufen_RecyclerViewAdapter(Einkaufen.this, einkaufsliste);
                    rVEinkaufenListe.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }, error -> {
                    Toast.makeText(Einkaufen.this, error.toString().trim(), Toast.LENGTH_SHORT).show();
                });

        /*
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
        */

        Volley.newRequestQueue(this).add(stringRequest);
    }
}
