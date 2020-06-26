package com.example.automationdevice;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    Activity activity;
    private Context context;
    private ArrayList id_projeto, projeto, cliente, endereco, data;


    Adapter(Activity activity, Context context, ArrayList  id_projeto,  ArrayList projeto, ArrayList cliente, ArrayList endereco, ArrayList data){
        this.activity = activity;
        this.context = context;
        this.id_projeto = id_projeto;
        this.projeto = projeto;
        this.cliente = cliente;
        this.endereco = endereco;
        this.data = data;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.txtProjeto.setText(String.valueOf((projeto.get(position))));
        holder.txtCliente.setText(String.valueOf((cliente.get(position))));
        holder.txtEndereco.setText(String.valueOf(endereco.get(position)));
        holder.data.setText(String.valueOf(data.get(position)));

    }

    @Override
    public int getItemCount() {

        return id_projeto.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtProjeto, txtCliente, txtEndereco, data;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtProjeto = itemView.findViewById(R.id.txtProjeto);
            txtCliente = itemView.findViewById(R.id.txtCliente);
            txtEndereco = itemView.findViewById(R.id.txtEndereco);
            data = itemView.findViewById(R.id.data);
            mainLayout = itemView.findViewById(R.id.mainLayout);

        }
    }
}
