package com.example.automationdevice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.Date;

public class MyDB extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Automacao.db";
    private static final int DATABASE_VERSION = 1;
    private Context context;
    //Variaveis da tabela do projeto
    private  static  final  String TABLE_PROJETO= "projeto";
    private  static  final String ID_PROJETO = "id_projeto";
    private static final String COLUMN_NAME_PROJETO = "projeto_nome";
    private static  final String COLUMN_NAME_CLIENTE = "projeto_cliente";
    private static  final String COLUMN_NAME_ENDERECO = "projeto_endereco";
    private static final String DATE = "data";



    public MyDB(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryProjeto = "CREATE TABLE IF NOT EXISTS "+ TABLE_PROJETO + " ( "
                + ID_PROJETO + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                COLUMN_NAME_PROJETO + " TEXT, " +
                COLUMN_NAME_CLIENTE + " TEXT, "
                + COLUMN_NAME_ENDERECO + " TEXT, "+
                DATE + " TEXT) ";

        db.execSQL(queryProjeto);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(" DROP TABLE IF EXISTS "+ TABLE_PROJETO);
        onCreate(db);

    }

    void AddProjeto(String Projeto, String Cliente, String Endereco, String Data ){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME_PROJETO, Projeto);
        cv.put(COLUMN_NAME_CLIENTE, Cliente);
        cv.put(COLUMN_NAME_ENDERECO, Endereco);
        cv.put(DATE, Data);

        long result = db.insert(TABLE_PROJETO,null, cv);
        if(result == -1){
            Toast.makeText(context, "FALHA AO INSERIR", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(context, "ADICIONADO COM SUCESSO", Toast.LENGTH_LONG).show();
        }

    }

    Cursor readAllDataProjeto(){
        String query = "SELECT * FROM "+ TABLE_PROJETO;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }

    void updateData(String row_id, String Projeto, String Cliente, String Endereco, String Data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME_PROJETO, Projeto);
        cv.put(COLUMN_NAME_CLIENTE, Cliente);
        cv.put(COLUMN_NAME_ENDERECO, Endereco);
        cv.put(DATE, Data);


        long result = db.update(TABLE_PROJETO, cv,"id_projeto=?",new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Falha ao alterar", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(context, "Alterado com sucesso!", Toast.LENGTH_LONG).show();
        }
    }
}
