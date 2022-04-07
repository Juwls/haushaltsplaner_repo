package com.example.ha_pla;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class Putzen extends Activity {

    private TextView tVPutzenTitel;
    private RecyclerView rVPutzenListe;
    private EditText eTPutzenEingabe;
    private Button buttonPutzen;
    private String URL = "http://10.0.2.2/android/registration.php";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.putzen_layout);

        tVPutzenTitel = findViewById(R.id.tVPutzenTitel);
        rVPutzenListe = findViewById(R.id.rVPutzenListe);
        eTPutzenEingabe = findViewById(R.id.eTPutzenEingabe);
        buttonPutzen = findViewById(R.id.buttonPutzen);
    }
}
