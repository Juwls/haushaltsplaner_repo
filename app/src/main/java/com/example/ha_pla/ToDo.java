package com.example.ha_pla;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class ToDo extends Activity {

    private TextView tVToDoTitel;
    private EditText eTToDoEingabe;
    private RecyclerView rVToDoListe;
    private Button buttonToDo;
    private String URL = "http://10.0.2.2/android/registration.php";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.todo_layout);

        tVToDoTitel = findViewById(R.id.tVToDoTitel);
        eTToDoEingabe = findViewById(R.id.eTToDoEingabe);
        rVToDoListe = findViewById(R.id.rVToDoListe);
        buttonToDo = findViewById(R.id.buttonToDo);

    }
}
