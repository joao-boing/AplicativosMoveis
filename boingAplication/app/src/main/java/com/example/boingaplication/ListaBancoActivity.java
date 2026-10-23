package com.example.boingaplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListaBancoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTexto = findViewById(R.id.editTexto);
        Button btnAdicionar = findViewById(R.id.btnAdicionar);
        ListView listView = findViewById(R.id.listView);

        SQLiteDatabase db = openOrCreateDatabase("banco.db", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS itens (texto TEXT)");

        ArrayList<String> itens = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT texto FROM itens", null);
        while (cursor.moveToNext()) {
            itens.add(cursor.getString(0));
        }
        cursor.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itens);
        listView.setAdapter(adapter);

        btnAdicionar.setOnClickListener(v -> {
            String texto = editTexto.getText().toString();
            db.execSQL("INSERT INTO itens (texto) VALUES (?)", new Object[]{texto});
            itens.add(texto);
            adapter.notifyDataSetChanged();
            editTexto.setText("");
        });
    }
}