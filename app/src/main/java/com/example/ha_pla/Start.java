package com.example.ha_pla;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

public class Start extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.start_layout);
    }

    public void haushalt (View view) {
        Intent zeigeHaushalt = new Intent (this, Haushalt.class);
        startActivity(zeigeHaushalt);
    }

    public void einkaufen (View view) {
        Intent zeigeEinkaufen = new Intent(this, Einkaufen.class);
        startActivity(zeigeEinkaufen);
    }

    public void putzen (View view) {
        Intent zeigePutzen = new Intent(this, Putzen.class);
        startActivity(zeigePutzen);
    }

    public void todo (View view) {
        Intent zeigeToDo = new Intent(this, ToDo.class);
        startActivity(zeigeToDo);
    }

    public void varKosten (View view) {
        Intent zeigeVarKosten = new Intent(this, variableKosten.class);
        startActivity(zeigeVarKosten);
    }

    public void fixKosten (View view) {
        Intent zeigeFixKosten = new Intent(this, FixKosten.class);
        startActivity(zeigeFixKosten);
    }
}
