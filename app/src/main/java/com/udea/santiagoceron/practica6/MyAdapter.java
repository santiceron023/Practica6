package com.udea.santiagoceron.practica6;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by santiago ceron on 1/11/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private final LayoutInflater inflater;
    private ArrayList<Libros> data;


    public MyAdapter(Context context, ArrayList<Libros> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.entry_recycler,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.sLibro.setText(data.get(position).getLibro());
        holder.sAutor.setText(data.get(position).getAutor());
        holder.sPersona.setText(data.get(position).getPersona());
        holder.sTelefono.setText(data.get(position).getTelefono());
        holder.sId.setText(Integer.toString(data.get(position).getId()));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder{
        TextView sLibro,sAutor,sPersona,sTelefono,sId;
        public MyViewHolder(View view) {
            super(view);
            sLibro = (TextView)itemView.findViewById(R.id.sLibro);
            sAutor  = (TextView)itemView.findViewById(R.id.sAutor);
            sPersona  = (TextView)itemView.findViewById(R.id.sPersona);
            sTelefono  = (TextView)itemView.findViewById(R.id.sTelefono);
            sId  = (TextView)itemView.findViewById(R.id.sId);
        }
    }
}
