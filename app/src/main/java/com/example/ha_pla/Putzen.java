package com.example.ha_pla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class Putzen extends AppCompatActivity {




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.putzen_layout);


        Button btnFrag1 = findViewById(R.id.btnFragMontag);
        btnFrag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PutzenMontagFragment fragmentMontag = new PutzenMontagFragment();
                Intent intent = getIntent();
                Bundle extras = intent.getExtras();
                extras.putString("tag", "montag");
                fragmentMontag.setArguments(extras);

                fragmentMontag.setArguments(extras);

                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView2, fragmentMontag, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name") // name can be null
                        .commit();
            }
        });



        Button btnFrag2 = findViewById(R.id.btnFragDienstag);
        btnFrag2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                PutzenDienstagFragment fragmentDienstag = new PutzenDienstagFragment();
                Intent intent = getIntent();
                Bundle extras = intent.getExtras();
                extras.putString("tag", "dienstag");
                fragmentDienstag.setArguments(extras);

                fragmentDienstag.setArguments(extras);
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView2, PutzenDienstagFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name") // name can be null
                        .commit();
            }
        });


    }



}
