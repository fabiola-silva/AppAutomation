package com.example.automationdevice;

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

    private Context context;
    private ArrayList projeto, cliente, endereco, data;

    Adapter(Context context, ArrayList projeto, ArrayList cliente, ArrayList endereco, ArrayList data){
        this.context = context;
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

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView projeto, cliente, endereco, data;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            projeto = itemView.findViewById(R.id.txtProjeto);
            cliente = itemView.findViewById(R.id.txtCliente);
            endereco = itemView.findViewById(R.id.txtEndereco);
            data = itemView.findViewById(R.id.data);
            mainLayout = itemView.findViewById(R.id.mainLayout);

        }
    }
}
