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
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Einkaufen extends Activity {

    private EditText eTEinkaufenEingabe;
    private String einkaufenEingabe;
    private String URL = "http://10.0.2.2/android/einkaufen.php";
    private RecyclerView rVEinkaufenListe;
    private RecyclerView.LayoutManager rVEinkaufenListeLayoutManager;
    private RecyclerView.Adapter rVEinkaufenListeAdapter;

    ArrayList<EinkaufenData> einkaufsliste = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.einkaufen_layout);

        eTEinkaufenEingabe = findViewById(R.id.eTEinkaufenEingabe);
        rVEinkaufenListe = (RecyclerView) findViewById(R.id.rVEinkaufenListe);

    }

    private void setUp(){

        String[] einkaufsliste = getResources().getStringArray();


        for(int i = 0; i < einkaufsliste.length;i++);

    }

   /* public void einkaufHinzufuegen(View view){

        einkaufenEingabe = eTEinkaufenEingabe.getText().toString().trim();

        if(!einkaufenEingabe.equals("")){
            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                    response -> {
                if (response.equals("success")) {

                }
                else if (response.equals("failure")) {

                }
            }, error -> Toast.makeText(getApplicationContext(), error.toString().trim(), Toast.LENGTH_SHORT).show()) {

                @NonNull
                @Override
                protected Map<String, String> getParams() {
                    HashMap<String, String> data = new HashMap<>();
                    data.put("", );

                    return data;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }

    } */
}
