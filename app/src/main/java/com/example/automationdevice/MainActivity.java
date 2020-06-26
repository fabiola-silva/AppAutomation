package com.example.automationdevice;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;


import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    int id;

    MyDB banco;
    ArrayList<String> idProjeto, txtProjeto, txtCliente, txtEndereco, txtData;
    Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        banco = new MyDB(MainActivity.this);
        idProjeto = new ArrayList<>();
        txtProjeto = new ArrayList<>();
        txtCliente = new ArrayList<>();
        txtEndereco = new ArrayList<>();
        txtData = new ArrayList<>();

        storeDataInArrayProjeto();

        adapter = new Adapter(MainActivity.this, this,  idProjeto, txtProjeto, txtCliente, txtEndereco, txtData);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this ));


    }

    // Esta função recriar o layout da aplicação com os dados atualizados.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { // mostra o botão de adicionar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.inserir_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) { // função de direcionar entre as telas
        if (item.getItemId() == R.id.add_button){
            id = getIntent().getIntExtra("id",-1);

            Intent intent = new Intent(MainActivity.this, Adicionar_Projeto.class);
            intent.putExtra("id", id);
            startActivityForResult(intent, 1);
        }

        return super.onOptionsItemSelected(item);
    }

    // Buscando dados do banco Projeto

    void storeDataInArrayProjeto(){


        Cursor cursor = banco.readAllDataProjeto();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "Sem dados.", Toast.LENGTH_LONG).show();
        }else{
            while (cursor.moveToNext()){ // vai percorrer um vetor de dados da tabela projeto
                idProjeto.add(cursor.getString(0));
                txtProjeto.add(cursor.getString(1));
                txtCliente.add(cursor.getString(2));
                txtEndereco.add(cursor.getString(3));
                txtData.add(cursor.getString(4));


            }
        }
    }


}
