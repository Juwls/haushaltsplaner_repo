package com.example.ha_pla;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class variableKosten extends Activity {

    private EditText eTFinanzVarEingabe,eTFinanzVarSumme;
    private TextView tVFinanzVariabelTitel, tVFinanzVarSummeLabel;
    private RecyclerView rVFinanzVarEintraege;
    private Button buttonFinanzVar;
    private String URL = "http://10.0.2.2/android/registration.php";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.finanzvariabel_layout);

        eTFinanzVarEingabe = findViewById(R.id.eTFinanzVarEingabe);
        eTFinanzVarSumme = findViewById(R.id.eTFinanzVarSumme);
        tVFinanzVariabelTitel = findViewById(R.id.tVFinanzVariabelTitel);
        tVFinanzVarSummeLabel = findViewById(R.id.tVFinanzVarSummeLabel);
        rVFinanzVarEintraege = findViewById(R.id.rVFinanzVarEintraege);
        buttonFinanzVar = findViewById(R.id.buttonFinanzVar);
    }
}
