package com.example.ha_pla;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class Login extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login_layout);
    }

    public void LogIn (View view) {
        Intent zeigeStart = new Intent(this, Start.class);
        startActivity(zeigeStart);
    }

    public void Registrierung (View view) {
        Intent zeigeRegistrierung = new Intent (this, Registrierung.class);
        startActivity(zeigeRegistrierung);
    }
}
