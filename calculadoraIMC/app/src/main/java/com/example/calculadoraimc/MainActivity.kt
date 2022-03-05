package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val btnClicked = findViewById<Button>(R.id.button);

        btnClicked.setOnClickListener { view ->
            val peso = (findViewById<EditText>(R.id.editTextNumberDecimal)).text.toString().toDouble();
            val altura = (findViewById<EditText>(R.id.editTextNumberDecimal2)).text.toString().toDouble();

            val imc = peso.div(altura.times(altura));

            Snackbar.make(
                view, "Seu IMC é: $imc",
                Snackbar.LENGTH_LONG
            ).setAction("Action", null).show();
        }
    }
}