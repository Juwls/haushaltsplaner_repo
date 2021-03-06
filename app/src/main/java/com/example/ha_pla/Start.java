package com.example.ha_pla;

import static android.content.Intent.EXTRA_EMAIL;

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
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        zeigeHaushalt.putExtras(extras);
        startActivity(zeigeHaushalt);

    }

    public void einkaufen (View view) {
        Intent zeigeEinkaufen = new Intent(this, Einkaufen.class);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        zeigeEinkaufen.putExtras(extras);
        startActivity(zeigeEinkaufen);
    }

    public void putzen (View view) {
        Intent zeigePutzen = new Intent(this, Putzen.class);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        zeigePutzen.putExtras(extras);
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
