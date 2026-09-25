package com.example.boingaplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityImc extends AppCompatActivity {

    EditText edtPeso, edtAltura;
    Button btnCalcular;

    Button btnBack;
    TextView txtResultado, txtClassificacao;
    ImageView imgClassificacao;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        edtPeso = findViewById(R.id.edtPeso);
        edtAltura = findViewById(R.id.edtAltura);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnBack = findViewById(R.id.button2);
        txtResultado = findViewById(R.id.txtResultado);
        txtClassificacao = findViewById(R.id.txtClassificacao);
        imgClassificacao = findViewById(R.id.imgClassificacao);

        btnCalcular.setOnClickListener(v -> calcular());

        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityImc.this, MainActivity.class);
            startActivity(intent);
        });
    }

    private void calcular() {
        String pesoTexto = edtPeso.getText().toString().replace(",", ".");
        String alturaTexto = edtAltura.getText().toString().replace(",", ".");

        if (pesoTexto.isEmpty() || alturaTexto.isEmpty()) {
            txtResultado.setText("Preencha os dois campos");
            txtClassificacao.setText("");
            imgClassificacao.setImageDrawable(null);
            return;
        }

        double peso = Double.parseDouble(pesoTexto);
        double altura = Double.parseDouble(alturaTexto);

        double imc = peso / (altura * altura);

        txtResultado.setText(String.format("IMC: %.2f", imc));

        if (imc < 18.5) {
            txtClassificacao.setText("Abaixo do peso");
            imgClassificacao.setImageResource(R.drawable.abaixo);
        } else if (imc < 25) {
            txtClassificacao.setText("Peso normal");
            imgClassificacao.setImageResource(R.drawable.normal);
        } else if (imc < 30) {
            txtClassificacao.setText("Sobrepeso");
            imgClassificacao.setImageResource(R.drawable.sobrepeso);
        } else if (imc < 35) {
            txtClassificacao.setText("Obesidade grau 1");
            imgClassificacao.setImageResource(R.drawable.obesidade1);
        } else if (imc < 40) {
            txtClassificacao.setText("Obesidade grau 2");
            imgClassificacao.setImageResource(R.drawable.obesidade2);
        } else {
            txtClassificacao.setText("Obesidade grau 3");
            imgClassificacao.setImageResource(R.drawable.obesidade3);
        }
    }
}