package com.example.lcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText txtAlcool, txtGaso;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtAlcool = findViewById(R.id.textAlcool);
        txtGaso = findViewById(R.id.txtGaso);
        txtResultado = findViewById(R.id.textResult);

    }

    public void calcular(View view){
        String alcool = txtAlcool.getText().toString();
        String gasolina = txtGaso.getText().toString();

        Boolean camposValidados = validarCampo(alcool, gasolina);
        if(camposValidados){

            Double valorAlcool = Double.parseDouble(alcool);
            Double valorGasolina = Double.parseDouble(gasolina);
            Double result = (valorAlcool/valorGasolina);
            if(result >= 0.7){
                txtResultado.setText("Melhor usar gasolina");
            }else {
                txtResultado.setText("Melhor usar Álcool");
            }


        }else {
            txtResultado.setText("Preencha os campos");
        }
    }

    public Boolean validarCampo(String cAlcool, String cGasolina){
        Boolean camposValidados = true;

        if(cAlcool.equals("") && cGasolina.equals("")){
            camposValidados = false;
        }
        return camposValidados;
    }
}