package com.example.calculadoradechurrasco

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

class FormFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflate = inflater.inflate(R.layout.fragment_form, container, false);

        val btnResult = inflate.findViewById<Button>(R.id.btnResult);

        btnResult.setOnClickListener{
            if ((inflate.findViewById<EditText>(R.id.edtNumberMen)).text.isEmpty()) {
                Snackbar.make(
                    requireView(), "Informe a quantidade de homens!",
                    Snackbar.LENGTH_LONG
                ).setAction("Action", null).show();

                return@setOnClickListener;
            }

            if ((inflate.findViewById<EditText>(R.id.edtNumberWomen)).text.isEmpty()) {
                Snackbar.make(
                    requireView(), "Informe a quantidade de mulheres!",
                    Snackbar.LENGTH_LONG
                ).setAction("Action", null).show();

                return@setOnClickListener;
            }

            if ((inflate.findViewById<EditText>(R.id.edtNumberChildren)).text.isEmpty()) {
                Snackbar.make(
                    requireView(), "Informe a quantidade de crianças!",
                    Snackbar.LENGTH_LONG
                ).setAction("Action", null).show();

                return@setOnClickListener;
            }

            val amountMen = inflate.findViewById<EditText>(R.id.edtNumberMen).text.toString().toInt();
            val amountWomen = inflate.findViewById<EditText>(R.id.edtNumberWomen).text.toString().toInt();
            val amountChildren = inflate.findViewById<EditText>(R.id.edtNumberChildren).text.toString().toInt();

            val fm = fragmentManager
            fm!!.beginTransaction()
                .replace(R.id.mainContainer, ResultadoFragment.newInstance(
                    amountMen,
                    amountWomen,
                    amountChildren,
                ),"ResultadoFragment").addToBackStack(null).commit();

        }

        return inflate;
    }

    companion object {
        @JvmStatic
        fun newInstance() = FormFragment().apply { }
    }
}