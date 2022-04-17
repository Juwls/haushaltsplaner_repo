package com.example.ha_pla;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ToDo_RecyclerViewAdapter extends RecyclerView.Adapter<ToDo_RecyclerViewAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<ToDoData> toDoListe;

    public ToDo_RecyclerViewAdapter(Context context, ArrayList<ToDoData> toDoListe) {
        this.context = context;
        this.toDoListe = toDoListe;

    }

    @NonNull
    @Override
    public ToDo_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //layout fuer jede zeile anzeigen
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.todo_listenobjekt_layout, parent, false);

        return new ToDo_RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ToDo_RecyclerViewAdapter.MyViewHolder holder, int position) {
        //zeige data je nach position im recyclerview

        holder.checked_tVToDoListenobjekt.setText(toDoListe.get(position).getAktivitaet());

    }

    @Override
    public int getItemCount() {

        return toDoListe.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        CheckedTextView checked_tVToDoListenobjekt;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            checked_tVToDoListenobjekt = itemView.findViewById(R.id.checked_tVToDoListenobjekt);

        }
    }
}
