package com.example.ha_pla;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class HaushaltErstellen extends Activity {
    private EditText eTErstelleHaushaltName;
    private String erstelleHaushaltName;
    //private final String URL = "http://87.106.169.186/hapla/android/haushaltErstellen.php";
    private final String URL = "http://10.0.2.2/android/haushaltErstellen.php";

    private Button btnHaushaltErstellen;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.haushalterstellen_layout);
        eTErstelleHaushaltName = findViewById(R.id.eTErstelleHaushaltName);
        btnHaushaltErstellen = findViewById((R.id.btnHaushaltErstellen));
        erstelleHaushaltName = "";
    }


    public void erstelleHaushalt(View view){
        erstelleHaushaltName = eTErstelleHaushaltName.getText().toString().trim();

        if(!erstelleHaushaltName.equals("")){
            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, response -> {
                if (response.equals("failure")) {
                    Toast.makeText(HaushaltErstellen.this, "Bitte versuchen Sie es erneut", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(HaushaltErstellen.this, "Haushalt erfolgreich erstellt", Toast.LENGTH_SHORT).show();
                    Intent zeigeStart = new Intent(HaushaltErstellen.this, Start.class);
                    Bundle extras = new Bundle();
                    extras.putString("EXTRA_idHaushalt", response);
                    zeigeStart.putExtras(extras);
                    startActivity(zeigeStart);
                    finish();
                }
            }, error -> Toast.makeText(getApplicationContext(), error.toString().trim(), Toast.LENGTH_SHORT).show()) {

                private Intent intent = getIntent();
                private Bundle extras = intent.getExtras();
                private String email_extra = extras.getString("EXTRA_email");
                @NonNull
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> data = new HashMap<>();
                    data.put("erstelleHaushaltName", erstelleHaushaltName);
                    data.put("email_extra", email_extra);
                    return data;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }else {
            Toast.makeText(HaushaltErstellen.this, "Bitte einen Namen angeben", Toast.LENGTH_SHORT).show();
        }
        }
    }

