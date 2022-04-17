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

public class Registrierung extends Activity {
    private EditText eTVorname, eTNachname, eTBenutzername, eTEmail, eTPasswort;
    private TextView tVAlreadyRegistered;
    private Button btnRegister;
    //private final String URL = "http://87.106.169.186/hapla/android/registration.php";
    private final String URL = "http://10.0.2.2/android/registration.php";
    private String vorname, nachname, benutzername, email, passwort;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrierung_layout);
        eTVorname = findViewById(R.id.eTVorname);
        eTNachname = findViewById(R.id.eTNachname);
        eTBenutzername = findViewById(R.id.eTBenutzername);
        eTEmail = findViewById(R.id.eTEmail);
        eTPasswort = findViewById(R.id.eTPasswort);
        tVAlreadyRegistered = findViewById(R.id.tVAlreadyRegistered);
        btnRegister = findViewById(R.id.btnRegister);
        vorname = nachname = benutzername = email = passwort = "";
    }

    public void save(View view) {
        vorname = eTVorname.getText().toString().trim();
        nachname = eTNachname.getText().toString().trim();
        benutzername = eTBenutzername.getText().toString().trim();
        email = eTEmail.getText().toString().trim();
        passwort = eTPasswort.getText().toString().trim();

        if(!vorname.equals("") && !nachname.equals("") && !benutzername.equals("") && !email.equals("") && !passwort.equals("")){
            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, response -> {
                if (response.equals("success")) {
                    Toast.makeText(Registrierung.this, "registration successful", Toast.LENGTH_SHORT).show();
                    Intent zeigeLogin = new Intent(Registrierung.this, Login.class);
                    startActivity(zeigeLogin);
                    finish();
                }
                else if (response.equals("failure")) {
                    Toast.makeText(Registrierung.this, "registration failed", Toast.LENGTH_SHORT).show();
                }
            }, error -> Toast.makeText(getApplicationContext(), error.toString().trim(), Toast.LENGTH_SHORT).show()) {

                @NonNull
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> data = new HashMap<>();
                    data.put("vorname", vorname);
                    data.put("nachname", nachname);
                    data.put("benutzername", benutzername);
                    data.put("email", email);
                    data.put("passwort", passwort);
                    return data;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }else {
            Toast.makeText(Registrierung.this, "Bitte alle Felder ausfuellen", Toast.LENGTH_SHORT).show();
        }
    }


    public void LogIn (View view) {
        Intent zeigeStart = new Intent(Registrierung.this, Login.class);
        startActivity(zeigeStart);
        finish();
    }
}
