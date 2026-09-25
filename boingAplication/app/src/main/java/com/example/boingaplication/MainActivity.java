package com.example.boingaplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText edMin = findViewById(R.id.edMin); // era edMax
        EditText edMax = findViewById(R.id.edMax);
        TextView textView = findViewById(R.id.textView);
        Button b = findViewById(R.id.button);
        Button c = findViewById(R.id.btnImc);

        // Botão do sorteio
        b.setOnClickListener(v -> {
            String smax = edMax.getText().toString();
            String smin = edMin.getText().toString();

            if (smin.trim().isEmpty()) {
                edMin.setError("Informe um valor");
                edMin.requestFocus();
                return;
            }
            if (smax.trim().isEmpty()) {
                edMax.setError("Informe um valor");
                edMax.requestFocus();
                return;
            }

            int min = Integer.parseInt(smin);
            int max = Integer.parseInt(smax);

            if (min > max) {
                edMax.setError("O valor máximo deve ser maior que o mínimo");
                return;
            }

            int r = new Random().nextInt(max - min + 1) + min;
            textView.setText(Integer.toString(r));
        });

        // Botão que abre a tela do IMC (era "b", agora é "c")
        c.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivityImc.class);
            startActivity(intent);
        });
    }
}