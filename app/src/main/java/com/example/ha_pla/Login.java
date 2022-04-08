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
    private EditText eTEmail, eTPasswort;
    private String email, passwort;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        email = passwort = ""; // initialize empty strings
        eTEmail = findViewById(R.id.eTEmail);
        eTPasswort = findViewById(R.id.eTPasswort);
    }

    public void loginAccount (View view) {
        email = eTEmail.getText().toString().trim();
        passwort = eTPasswort.getText().toString().trim();
        if (!email.equals("") && !passwort.equals("")) {

            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, response -> {

                if (response.equals("success")) {
                    Intent zeigeStart = new Intent(this, Start.class);
                    startActivity(zeigeStart);
                    finish();
                } else if (response.equals("failure")) {
                    Toast.makeText(Login.this, "Login fehlgeschlagen", Toast.LENGTH_SHORT).show();
                }
            }, error -> Toast.makeText(Login.this, error.toString().trim(), Toast.LENGTH_SHORT).show()){

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

