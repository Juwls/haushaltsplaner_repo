package com.example.ha_pla;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class FixKosten extends Activity {

    private EditText etFinanzFixEingabe, eTfinanzfixSumme;
    private TextView tVfinanzfixSummeLabel, tVfinanzfixTitel;
    private Button buttonFinanzFix;
    private RecyclerView rVfinanzfix;
    private String URL = "http://10.0.2.2/android/registration.php";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.finanzfix_layout);

        etFinanzFixEingabe = findViewById(R.id.eTFinanzFixEingabe);
        eTfinanzfixSumme = findViewById(R.id.eTFinanzVarSumme);
        tVfinanzfixSummeLabel = findViewById(R.id.tVfinanzfixSummeLabel);
        tVfinanzfixTitel = findViewById(R.id.tVfinanzfixTitel);
        buttonFinanzFix = findViewById(R.id.buttonFinanzFix);
        rVfinanzfix = findViewById(R.id.rVfinanzfix);
    }
}
