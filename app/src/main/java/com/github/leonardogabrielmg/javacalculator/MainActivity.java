package com.github.leonardogabrielmg.javacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText nota1, nota2, nota3, nota4, numeroFaltas;
    private Button btCalcular;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nota1 = findViewById(R.id.nota1);
        nota2 = findViewById(R.id.nota2);
        nota3 = findViewById(R.id.nota3);
        nota4 = findViewById(R.id.nota4);
        numeroFaltas = findViewById(R.id.numeroFaltas);
        btCalcular = findViewById(R.id.bt_calcular);
        txtResultado = findViewById(R.id.txt_resultado);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(nota1.getText().toString());
                int n2 = Integer.parseInt(nota2.getText().toString());
                int n3 = Integer.parseInt(nota3.getText().toString());
                int n4 = Integer.parseInt(nota4.getText().toString());
                int faltas = Integer.parseInt(numeroFaltas.getText().toString());

                int media = (n1+n2+n3+n4)/4;

                if (media >= 5 && faltas < 20){
                    txtResultado.setText("Aluno aprovado! \nMedia final = " + media);
                    txtResultado.setTextColor(getColor(R.color.green));
                } else if (faltas > 20) {
                    txtResultado.setText("Aluno reprovado por faltas!\nMedia final = " + media);
                    txtResultado.setTextColor(getColor(R.color.red));
                } else if (media < 5) {
                    txtResultado.setText("Aluno reprovado por nota!\nMedia final = " + media);
                    txtResultado.setTextColor(getColor(R.color.red));
                }
            }
        });
    }
}