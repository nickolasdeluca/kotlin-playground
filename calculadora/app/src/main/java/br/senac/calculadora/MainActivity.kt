package br.senac.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalcular = findViewById<Button>(R.id.btnCalcular);

        btnCalcular.setOnClickListener { view ->
            if ((findViewById<EditText>(R.id.edtValor1)).text.isEmpty()) {
                Snackbar.make(
                    view, "Digite o valor 1!",
                    Snackbar.LENGTH_LONG
                ).setAction("Action", null).show();

                return@setOnClickListener;
            }

            if ((findViewById<EditText>(R.id.edtValor2)).text.isEmpty()) {
                Snackbar.make(
                    view, "Digite o valor 2!",
                    Snackbar.LENGTH_LONG
                ).setAction("Action", null).show();

                return@setOnClickListener;
            }

            val valor1 = (findViewById<EditText>(R.id.edtValor1)).text.toString().toDouble();
            val valor2 = (findViewById<EditText>(R.id.edtValor2)).text.toString().toDouble();

            val soma = valor1.plus(valor2);
            val subtracao = valor1.minus(valor2);
            val multiplicacao = valor1.times(valor2);

            var divisao = 0.0;

            if (!(valor1.equals(0.0)) || !(valor2.equals(0.0))) {
                divisao = valor1.div(valor2);
            }

            Snackbar.make(
                view, "Valores calculados: Soma: $soma Subtração: $subtracao Multiplicação: $multiplicacao Divisão: $divisao",
                Snackbar.LENGTH_LONG
            ).setAction("Action", null).show();

        }
    }
}