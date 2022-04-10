package com.example.ha_pla;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

public class Login extends Activity {

    private final String URL = "http://10.0.2.2/android/login.php";
    private final String URL_istHaushaltVorhanden = "http://10.0.2.2/android/haushaltAbrufen.php";
    private EditText eTEmail, eTPasswort;
    private String email, passwort;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        email = passwort = "";
        eTEmail = findViewById(R.id.eTEmail);
        eTPasswort = findViewById(R.id.eTPasswort);
    }

    public void loginAccount (View view) {
        email = eTEmail.getText().toString().trim();
        passwort = eTPasswort.getText().toString().trim();
        if (!email.equals("") && !passwort.equals("")) {

            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, response -> {
                if (response.equals("success")) {
                    StringRequest stringRequestIstHaushaltVorhanden= new StringRequest(Request.Method.POST, URL_istHaushaltVorhanden, responseIstHaushaltVorhanden -> {
                        if (responseIstHaushaltVorhanden.equals("failure")) {
                            Intent zeigeHaushaltErstellen = new Intent(this, HaushaltErstellen.class);
                            Bundle extras = new Bundle();
                            extras.putString("EXTRA_email", email);
                            zeigeHaushaltErstellen.putExtras(extras);
                            startActivity(zeigeHaushaltErstellen);
                            finish();

                        }else {
                            Intent zeigeStart = new Intent(this, Start.class);
                            Bundle extras = new Bundle();
                            extras.putString("EXTRA_idHaushalt", responseIstHaushaltVorhanden);
                            zeigeStart.putExtras(extras);
                            startActivity(zeigeStart);
                            finish();
                        }
                    }, error -> Toast.makeText(Login.this, error.toString().trim(), Toast.LENGTH_SHORT).show())

                    {
                        @NonNull
                        @Override
                        protected Map<String, String> getParams() {
                        Map<String, String> data = new HashMap<>();
                        data.put("email", email);
                        return data;
                    }
                    };

                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(stringRequestIstHaushaltVorhanden);


                } else if (response.equals("failure")) {
                    Toast.makeText(Login.this, "Login fehlgeschlagen", Toast.LENGTH_SHORT).show();
                }
            }, error -> Toast.makeText(Login.this, error.toString().trim(), Toast.LENGTH_SHORT).show())
            {

                @NonNull
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> data = new HashMap<>();
                    data.put("email", email);
                    data.put("passwort", passwort);
                    return data;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }else{
            Toast.makeText(this, "Bitte alle Felder ausfuellen", Toast.LENGTH_SHORT).show();
        }
    }


    public void Registrierung (View view) {
        Intent zeigeRegistrierung = new Intent (this, Registrierung.class);
        startActivity(zeigeRegistrierung);
        finish();
    }
}


