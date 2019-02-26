package com.example.appsqliteciudades;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.appsqliteciudades.model.Ciudad;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.MiViewHolder> implements View.OnClickListener {

    private ArrayList<Ciudad> listaCiudades;
    private View.OnClickListener listener;


    public static class MiViewHolder extends RecyclerView.ViewHolder{

        private TextView tvCiudad;
        private TextView tvProvincia;
        private TextView tvNunHab;


        public MiViewHolder(View itemView) {
            super(itemView);
            tvCiudad=itemView.findViewById(R.id.tvNomCiudad);
            tvProvincia=itemView.findViewById(R.id.tvProvincia);
            tvNunHab=itemView.findViewById(R.id.tvNumHab);

        }

        public void bindCiudad(Ciudad ciudad){
            tvCiudad.setText(ciudad.getNombre());
            tvProvincia.setText(ciudad.getProvincia());
            tvNunHab.setText("Numero de habitantes: "+ciudad.getNumHab());
        }

        public TextView getTvCiudad() {
            return tvCiudad;
        }

        public TextView getTvProvincia() {
            return tvProvincia;
        }

        public TextView getTvNunHab() {
            return tvNunHab;
        }
    }

    public Adaptador(ArrayList<Ciudad> listaCiudades){
        this.listaCiudades=listaCiudades;
    }



    @Override
    public Adaptador.MiViewHolder onCreateViewHolder(ViewGroup parent, int ViewType) {
       View v= LayoutInflater.from(parent.getContext())
               .inflate(R.layout.rv_layout, parent, false);
       v.setOnClickListener(this);
       MiViewHolder vh= new MiViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MiViewHolder holder, int position) {

        holder.bindCiudad(listaCiudades.get(position));
    }

    @Override
    public int getItemCount() {
        return listaCiudades.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }

    }


}
