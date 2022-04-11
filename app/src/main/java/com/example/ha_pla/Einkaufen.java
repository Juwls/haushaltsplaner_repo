package com.example.ha_pla;

import android.app.Activity;
import android.content.Intent;
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

public class Einkaufen extends Activity  {

    private RecyclerView rVEinkaufenListe;
    private final String URL_load = "http://10.0.2.2/android/einkaufen.php";
    private final String URL_add = "http://10.0.2.2/android/einkaufenAdd.php";
    ArrayList<EinkaufenData> einkaufsliste = new ArrayList<>();
    private Button btnEinkaufHinzufuegen;
    private EditText eTEinkaufenEingabe;
    private String einkaufenEingabe;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.einkaufen_layout);
        eTEinkaufenEingabe = findViewById(R.id.eTEinkaufenEingabe);
        btnEinkaufHinzufuegen = findViewById(R.id.btnEinkaufHinzufuegen);
        rVEinkaufenListe = findViewById(R.id.rVEinkaufenListe);
        rVEinkaufenListe.setHasFixedSize(true);
        rVEinkaufenListe.setLayoutManager(new LinearLayoutManager(this));
        einkaufsliste = new ArrayList<>();
        einkaufenEingabe = "";

        ladeEinkaufslisteVonDb();

    }


    public void speicherEinkaufsobjekt(View view) {
        einkaufenEingabe = eTEinkaufenEingabe.getText().toString().trim();

        if (!einkaufenEingabe.equals("")) {
            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_add, response -> {
                if (response.equals("success")) {
                    Toast.makeText(Einkaufen.this, "erfolgreich hinzugefuegt", Toast.LENGTH_SHORT).show();
                    ladeEinkaufslisteVonDb();

                } else if(response.equals("failure")){
                    Toast.makeText(Einkaufen.this, "ein Fehler ist aufgetreten", Toast.LENGTH_SHORT).show();
                }

                }, error -> Toast.makeText(getApplicationContext(), error.toString().trim(), Toast.LENGTH_SHORT).show()) {

                private Intent intent = getIntent();
                private Bundle extras = intent.getExtras();
                private String idHaushalt_extra = extras.getString("EXTRA_idHaushalt");
                @NonNull
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> data = new HashMap<>();
                    data.put("einkaufenEingabe", einkaufenEingabe);
                    data.put("idHaushalt", idHaushalt_extra);
                    return data;
                }
            };
        /*
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
        */

            Volley.newRequestQueue(this).add(stringRequest);

        } else {
            Toast.makeText(Einkaufen.this, "Bitte geben Sie ein Einkaufsobjekt ein", Toast.LENGTH_SHORT).show();
        }
    }

    public void ladeEinkaufslisteVonDb() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_load,
                response -> {
                    try {
                        JSONArray array = new JSONArray(response);
                        for (int i = 0; i < array.length(); i++) {

                            JSONObject einkaufsobjekt = array.getJSONObject(i);
                            einkaufsliste.add(new EinkaufenData(
                                    einkaufsobjekt.getString("einkaufsobjekt")
                            ));
                        }

                        Einkaufen_RecyclerViewAdapter adapter = new Einkaufen_RecyclerViewAdapter(Einkaufen.this, einkaufsliste);
                        rVEinkaufenListe.setAdapter(adapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }, error -> Toast.makeText(Einkaufen.this, error.toString().trim(), Toast.LENGTH_SHORT).show())

                {

                    private Intent intent = getIntent();
                    private Bundle extras = intent.getExtras();
                    private String idHaushalt_extra = extras.getString("EXTRA_idHaushalt");
                    @NonNull
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> data = new HashMap<>();
                        data.put("idHaushalt", idHaushalt_extra);
                        return data;
                    }
                };


        /*
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
        */

        Volley.newRequestQueue(this).add(stringRequest);
    }
}
