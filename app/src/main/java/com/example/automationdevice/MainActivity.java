package com.example.automationdevice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

}
