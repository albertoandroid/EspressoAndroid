package com.androiddesdecero.espressoudemy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.androiddesdecero.espressoudemy.utils.Persona;
import com.androiddesdecero.espressoudemy.utils.PersonaAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private List<Persona> personas;
    private RecyclerView rv;
    private PersonaAdapter adapter;
    private Button recyclerActivityBtWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        setUpList();
        setUpView();

    }

    private void setUpView(){
        recyclerActivityBtWebView = findViewById(R.id.recyclerActivityBtWebView);
        rv = findViewById(R.id.recyclerActivityRv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(layoutManager);
        adapter = new PersonaAdapter(personas);
        rv.setAdapter(adapter);

        recyclerActivityBtWebView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(getApplicationContext(), IdlingActivity.class));
            }
        });
    }


    private void setUpList(){
        personas = new ArrayList<>();
        personas.add(new Persona("Alberto", "30"));
        personas.add(new Persona("Maria", "29"));
        personas.add(new Persona("Monica", "45"));
        personas.add(new Persona("Roberto", "20"));
        personas.add(new Persona("Luis", "50"));
        personas.add(new Persona("Alba", "45"));
        personas.add(new Persona("Adolfo", "33"));
        personas.add(new Persona("Estrella", "22"));
        personas.add(new Persona("Manuel", "20"));
        personas.add(new Persona("Alfonso", "50"));

        personas.add(new Persona("Mariano", "30"));
        personas.add(new Persona("Maria", "29"));
        personas.add(new Persona("Monica", "45"));
        personas.add(new Persona("Roberto", "20"));
        personas.add(new Persona("Luis", "50"));
        personas.add(new Persona("Alba", "45"));
        personas.add(new Persona("Adolfo", "33"));
        personas.add(new Persona("Estrella", "22"));
        personas.add(new Persona("Manuel", "20"));
        personas.add(new Persona("Pablo", "50"));
    }
}
