package com.example.ha_pla;

import static java.sql.Types.NULL;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class PutzenMontagFragment extends Fragment {
   private TextView tVFrag1;
   String frag1;
   private String idHaushalt_extra;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_putzen_montag, container, false);
        tVFrag1 = view.findViewById(R.id.tVFrag1);

        Bundle extras = getArguments();
        if(extras != null){
            idHaushalt_extra = extras.getString("EXTRA_idHaushalt");
        }
        tVFrag1.setText(idHaushalt_extra);

        return view;
    }
}