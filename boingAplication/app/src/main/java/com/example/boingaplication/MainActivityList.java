package com.example.boingaplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivityList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        EditText editTexto = findViewById(R.id.editTexto);
        Button btnAdicionar = findViewById(R.id.btnAdicionar);
        Button btnVoltar = findViewById(R.id.btnBack);
        Button btnProximo = findViewById(R.id.btnProximo);
        ListView listView = findViewById(R.id.listView);

        ArrayList<String> itens = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itens);
        listView.setAdapter(adapter);

        btnAdicionar.setOnClickListener(v -> {
            String texto = editTexto.getText().toString().trim();
            if (!texto.isEmpty()) {
                itens.add(texto);
                adapter.notifyDataSetChanged();
                editTexto.setText("");
            }
        });

        btnVoltar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityList.this, MainActivityImc.class);
            startActivity(intent);
        });

        btnProximo.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityList.this, MainActivityImages.class);
            startActivity(intent);
        });
    }
}
