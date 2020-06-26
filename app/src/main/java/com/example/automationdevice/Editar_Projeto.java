package com.example.automationdevice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Editar_Projeto extends AppCompatActivity {

    EditText EdtProjeto, EdtCliente, EdtEndereco;
    String id, projeto, cliente, endereco;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar__projeto);

        //seta o titulo no actionBar
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle("Editar projeto");
        }

        EdtProjeto = findViewById(R.id.edtAlterarProjeto);
        EdtCliente = findViewById(R.id.edtAlterarCliente);
        EdtEndereco = findViewById(R.id.edtAlterarEndereco);

        getAndSetIntentData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.editar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    void getAndSetIntentData() { // verifica se os dados existem
        if (getIntent().hasExtra("id_Projeto") && getIntent().hasExtra("Projeto") &&
                getIntent().hasExtra("cliente_Projeto") && getIntent().hasExtra("endereco_Projeto")) {
            //Extrai os dados e seta em outras variaveis
            id = getIntent().getStringExtra("id_Projeto");
            projeto = getIntent().getStringExtra("Projeto");
            cliente = getIntent().getStringExtra("cliente_Projeto");
            endereco = getIntent().getStringExtra("endereco_Projeto");


            //Seta os dados em cada campo correspondente
            EdtProjeto.setText(projeto);
            EdtCliente.setText(cliente);
            EdtEndereco.setText(endereco);

        } else {
            Toast.makeText(this, "Não têm dados.", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy"); // padronizar a data no padrão brasileiro.
        Date data = new Date(); //verifica a data
        final String dataFormatada  = formatoData.format(data);//converte a data para o formato atual.


        if (item.getItemId() == R.id.update_button){//verifica o botão se é igual ao id correspondente

            MyDB banco = new MyDB(Editar_Projeto.this);
            projeto = EdtProjeto.getText().toString().trim();
            cliente = EdtCliente.getText().toString().trim();
            endereco = EdtEndereco.getText().toString().trim();
            banco.updateData(id, projeto , cliente, endereco, dataFormatada);
            finish();
        }



        return super.onOptionsItemSelected(item);
    }

}
