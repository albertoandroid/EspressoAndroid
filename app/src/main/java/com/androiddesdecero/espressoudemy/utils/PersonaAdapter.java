package com.androiddesdecero.espressoudemy.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androiddesdecero.espressoudemy.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PersonaAdapter extends RecyclerView.Adapter<PersonaAdapter.PersonaViewHolder> {

    private List<Persona> personas;

    public PersonaAdapter(List<Persona> personas){
        this.personas = personas;
    }

    @NonNull
    @Override
    public PersonaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_persona, parent, false);
        return new PersonaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonaViewHolder holder, int position) {
        holder.tvNombre.setText(personas.get(position).getNombre());
        holder.tvEdad.setText(personas.get(position).getEdad());
    }

    @Override
    public int getItemCount() {
        return personas.size();
    }

    static class PersonaViewHolder extends RecyclerView.ViewHolder{

        private TextView tvNombre;
        private TextView tvEdad;

        public PersonaViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvEdad = itemView.findViewById(R.id.tvEdad);
        }
    }
}


