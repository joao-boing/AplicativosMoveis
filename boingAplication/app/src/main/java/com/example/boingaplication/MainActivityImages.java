package com.example.boingaplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityImages extends AppCompatActivity {

    int[] imagens = {
            R.drawable.cachorro,
            R.drawable.gardem,
            R.drawable.happy,
            R.drawable.patinho,
            R.drawable.porquinho,
    };
    int posicao = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        ImageView imageView = findViewById(R.id.imageView);
        Button btnAnterior = findViewById(R.id.btnAnterior);
        Button btnProximo = findViewById(R.id.btnProximo);
        Button btnVoltar = findViewById(R.id.btnBack);

        imageView.setImageResource(imagens[posicao]);

        btnAnterior.setOnClickListener(v -> {
            if (posicao == 0) posicao = imagens.length -1;
            else posicao--;
            imageView.setImageResource(imagens[posicao]);
        });

        btnProximo.setOnClickListener(v -> {
            if (posicao == (imagens.length - 1)) posicao = 0;
            else posicao++;
            imageView.setImageResource(imagens[posicao]);
        });

        btnVoltar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityImages.this, MainActivityList.class);
            startActivity(intent);
        });
    }
}