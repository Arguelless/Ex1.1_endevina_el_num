package com.example.ex12_endevina_el_numero_arguelles;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int randomNum;
    int numeros = 0;
    private int[] historial;
    private int numIntentos;
    private EditText inputnumber;
    private TextView ranking;
    private TextView intentos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputnumber = findViewById(R.id.inputnumber);
        ranking = findViewById(R.id.ranking);
        intentos = findViewById(R.id.intentos);
        Button button_endevinar = findViewById(R.id.button_endevinar);


        Random random = new Random();
        randomNum = random.nextInt(100) + 1;
        numIntentos = 0;
        button_endevinar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkGuess();
            }
        });
    }


    private void checkGuess() {
        numIntentos ++;

        String textoIntento = inputnumber.getText().toString();

        if (!textoIntento.isEmpty()) {
            int userGuess = Integer.parseInt(textoIntento);

            // Compara el intento del usuario con el número aleatorio.
            if (userGuess == randomNum) {

                Toast.makeText(this, "¡Adivinaste!", Toast.LENGTH_SHORT).show();

                // Puedes guardar la cantidad de intentos y actualizar la leaderboard aquí.
                intentos.setText("");
                ranking.setText("");

            } else {
                intentos.append(numIntentos + ": " + userGuess + "\n");
            }
            inputnumber.setText("");
            // Actualiza la cantidad de intentos en la vista.

        } else {
            Toast.makeText(this, "Por favor, ingresa un número.", Toast.LENGTH_SHORT).show();
        }
    }
    private void funcRanking(int guess){


    }

    }