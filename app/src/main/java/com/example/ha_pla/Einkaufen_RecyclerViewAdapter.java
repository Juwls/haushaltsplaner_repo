package com.example.ha_pla;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Einkaufen_RecyclerViewAdapter extends RecyclerView.Adapter<Einkaufen_RecyclerViewAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<EinkaufenData> einkaufsliste;

    public Einkaufen_RecyclerViewAdapter(Context context, ArrayList<EinkaufenData> einkaufsliste) {
        this.context = context;
        this.einkaufsliste = einkaufsliste;

    }

    @NonNull
    @Override
    public Einkaufen_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //layout fuer jede zeile anzeigen
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.einkaufen_listenobjekt_layout, parent, false);

        return new Einkaufen_RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Einkaufen_RecyclerViewAdapter.MyViewHolder holder, int position) {
       //zeige data je nach position im recyclerview

       holder.checked_tVEinkaufListenobjekt.setText(einkaufsliste.get(position).getEinkaufsobjekt());

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
