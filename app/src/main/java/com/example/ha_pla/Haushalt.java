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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Haushalt extends Activity {

    private TextView tVHaushaltBezeichnung;
    //private final String URL="http://87.106.169.186/hapla/android/zeigeHaushalt.php";
    //private final String URL_mitgliedHinzufuegen = "http://87.106.169.186/hapla/android/mitgliedHinzufuegen.php";
    private final String URL="http://10.0.2.2/android/zeigeHaushalt.php";
    private final String URL_mitgliedHinzufuegen = "http://10.0.2.2/android/mitgliedHinzufuegen.php";
    private EditText eTMitgliedHinzufuegen;
    private Button btnMitgliedHinzufuegen;
    private String mitgliedHinzufuegen;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.haushalt_layout);
        tVHaushaltBezeichnung = findViewById(R.id.tVHaushaltBezeichnung);
        eTMitgliedHinzufuegen = findViewById(R.id.eTMitgliedHinzufuegen);
        btnMitgliedHinzufuegen = findViewById(R.id.btnMitgliedHinzufuegen);
        mitgliedHinzufuegen = "";
        zeigeHaushaltsBezeichnung();
    }

    private void zeigeHaushaltsBezeichnung(){
            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, response -> {
                if(response.equals("failure")){
                    Toast.makeText(Haushalt.this, "Haushalt konnte nicht geladen werden", Toast.LENGTH_SHORT).show();
                }else{
                    tVHaushaltBezeichnung.setText(response);
                }

            }, error -> Toast.makeText(getApplicationContext(), error.toString().trim(), Toast.LENGTH_SHORT).show())

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
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);

    }

    public void mitgliedHinzufuegen(View view) {
        mitgliedHinzufuegen = eTMitgliedHinzufuegen.getText().toString().trim();
        if (!mitgliedHinzufuegen.equals("")) {
            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_mitgliedHinzufuegen, response -> {
                if (response.equals("failure")) {
                    Toast.makeText(Haushalt.this, "Ein Fehler ist aufgetreten", Toast.LENGTH_SHORT).show();
                } else if (response.equals("success")) {
                    Toast.makeText(Haushalt.this, "Neues Mitglied wurde hinzugefuegt", Toast.LENGTH_SHORT).show();
                }

            }, error -> Toast.makeText(getApplicationContext(), error.toString().trim(), Toast.LENGTH_SHORT).show()) {
                private Intent intent = getIntent();
                private Bundle extras = intent.getExtras();
                private String idHaushalt_extra = extras.getString("EXTRA_idHaushalt");

                @NonNull
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> data = new HashMap<>();
                    data.put("idHaushalt", idHaushalt_extra);
                    data.put("mitgliedHinzufuegen", mitgliedHinzufuegen);
                    return data;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);

        }else {
            Toast.makeText(Haushalt.this, "Bitte geben Sie eine Email an", Toast.LENGTH_SHORT).show();
        }
    }
}
