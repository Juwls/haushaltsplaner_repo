package com.example.ha_pla;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Einkaufen extends Activity {

    private TextView einkaufenTitel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.einkaufen_layout);
    }
}
