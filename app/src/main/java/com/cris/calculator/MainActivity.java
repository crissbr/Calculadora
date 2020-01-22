package com.cris.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText inputNumeroUm;
    private EditText inputNumeroOutro;
    private Button botaoCalcular;
    private TextView textViewResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        botaoCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                logicaBotaoCalcular();

            }
        });
    }

    private void logicaBotaoCalcular() {
        if (!inputNumeroUm.getText().toString().isEmpty() && !inputNumeroOutro.getText().toString().isEmpty()){
            int numUm = Integer.parseInt(inputNumeroUm.getText().toString());
            int numDois = Integer.parseInt(inputNumeroOutro.getText().toString());

            String resultado = String.valueOf(calcular(numUm, numDois));

            inputNumeroUm.getText().clear();
            inputNumeroOutro.getText().clear();

            textViewResultado.setText(resultado);
        } else {
            inputNumeroUm.setError("Campo inválido");
            inputNumeroOutro.setError("Campo inválido");
        }
    }

    private void initViews(){
        inputNumeroUm = findViewById(R.id.edit_text_numero_um);
        inputNumeroOutro = findViewById(R.id.edit_text_numero_outro);
        botaoCalcular = findViewById(R.id.button_calcular);
        textViewResultado = findViewById(R.id.text_resultado);
    }

    private int calcular(int numUm, int numDois){
        return numUm + numDois;
    }
}


