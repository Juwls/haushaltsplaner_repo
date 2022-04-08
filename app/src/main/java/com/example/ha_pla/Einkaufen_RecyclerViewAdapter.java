package com.example.ha_pla;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Einkaufen_RecyclerViewAdapter extends RecyclerView.Adapter<Einkaufen_RecyclerViewAdapter.MyViewHolder> {
    Context context;

    public Einkaufen_RecyclerViewAdapter(Context context, ArrayList<EinkaufenData>einkaufsliste) {
        this.context = context;
    }



    @NonNull
    @Override
    public Einkaufen_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

         return null;
    }

    @Override
    public void onBindViewHolder(@NonNull Einkaufen_RecyclerViewAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {

        return einkaufsliste.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        CheckedTextView checked_tVEinkaufListenobjekt;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            checked_tVEinkaufListenobjekt = itemView.findViewById(R.id.checked_tVEinkaufListenobjekt);

        }
    }
}
