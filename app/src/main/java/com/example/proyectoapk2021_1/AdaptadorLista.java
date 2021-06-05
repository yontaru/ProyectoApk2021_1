package com.example.proyectoapk2021_1;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdaptadorLista extends RecyclerView.Adapter<AdaptadorLista.viewHolder> {

    ArrayList<Actividad> listadedatos;

    public AdaptadorLista(ArrayList<Actividad> listadedatos){

        this.listadedatos =listadedatos;
    }

    @NonNull
    @Override
    public AdaptadorLista.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vistaListado = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_de_lista,parent,false);
        return new viewHolder(vistaListado);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorLista.viewHolder holder, int position) {
        holder.actualizarDatosdeItem(listadedatos.get(position));


    }

    @Override
    public int getItemCount() {

        return listadedatos.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder
    {
        TextView nombreActividad, descripcionActividad;
        ImageView fotoActividad;

        public viewHolder(@NonNull View itemView){
        super(itemView);

        nombreActividad=itemView.findViewById(R.id.nombreActividad);
        descripcionActividad=itemView.findViewById(R.id.descripcionActividadMain);
        fotoActividad=itemView.findViewById(R.id.fotoActividadMain);

        }

        public void actualizarDatosdeItem(Actividad datos){

            nombreActividad.setText(datos.getNombreActividad());
            descripcionActividad.setText(datos.getDescripcionActividad());
            Picasso.with(itemView.getContext())
                    .load(datos.getFotoActividad())
                    .into(fotoActividad);


        }
    }

}
