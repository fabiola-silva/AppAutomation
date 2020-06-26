package com.example.automationdevice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Adicionar_Projeto extends AppCompatActivity {

    EditText edtProjeto, edtCliente, edtEndereco;
    Button btnSalvar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar__projeto);

        edtProjeto  = findViewById(R.id.edtProjeto);
        edtCliente = findViewById(R.id.edtCliente);
        edtEndereco = findViewById(R.id.edtEndereco);
        btnSalvar = findViewById(R.id.btnSalvar);

        SimpleDateFormat formatoData = new SimpleDateFormat("dd-MM-yyyy"); // padronizar a data no padrão brasileiro.
        Date data = new Date(); //verifica a data
        final String dataFormatada  = formatoData.format(data);//converte a data para o formato atual.

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDB banco = new MyDB (Adicionar_Projeto.this);
                 banco.AddProjeto(edtProjeto.getText().toString().trim(),
                        edtCliente.getText().toString().trim(),
                        edtEndereco.getText().toString().trim(),
                        dataFormatada );
                 finish();
            }
        });

    }
}
