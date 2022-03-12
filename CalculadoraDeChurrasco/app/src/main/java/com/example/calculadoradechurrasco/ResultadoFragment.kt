package com.example.calculadoradechurrasco

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

private var AMOUNTMEN: Int = 0;
private var AMOUNTWOMEN: Int = 0;
private var AMOUNTCHILDREN: Int = 0;

class ResultadoFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
    }

    private fun howMuchMeat(amountMen: Int, amountWomen: Int, amountChildren: Int): Double {
        return 0
            .plus(amountMen.times(300))
            .plus(amountWomen.times(280))
            .plus(amountChildren.times(150))
            .toDouble();
    }

    private fun howMuchSausage(amountMen: Int, amountWomen: Int, amountChildren: Int): Double {
        return 0
            .plus(amountMen.times(200))
            .plus(amountWomen.times(180))
            .plus(amountChildren.times(100))
            .toDouble();
    }

    private fun howMuchBeer(amountMen: Int, amountWomen: Int): Double {
        return 0
            .plus(amountMen.times(1500))
            .plus(amountWomen.times(1000))
            .toDouble();
    }

    private fun howMuchSoda(amountMen: Int, amountWomen: Int, amountChildren: Int): Double {
        return 0
            .plus(amountMen.times(250))
            .plus(amountWomen.times(450))
            .plus(amountChildren.times(300))
            .toDouble();
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflate = inflater.inflate(R.layout.fragment_resultado, container, false);

        val edtMeat = inflate.findViewById<EditText>(R.id.edtMeat);
        val edtSausages = inflate.findViewById<EditText>(R.id.edtSausage);
        val edtBeer = inflate.findViewById<EditText>(R.id.edtBeer);
        val edtSoda = inflate.findViewById<EditText>(R.id.edtSoda);

        edtMeat.setText(String.format("%.2f", howMuchMeat(AMOUNTMEN, AMOUNTWOMEN, AMOUNTCHILDREN)));
        edtMeat.isFocusable = false;
        edtMeat.isFocusableInTouchMode = false;

        edtSausages.setText(String.format("%.2f", howMuchSausage(AMOUNTMEN, AMOUNTWOMEN, AMOUNTCHILDREN)));
        edtSausages.isFocusable = false;
        edtSausages.isFocusableInTouchMode = false;

        edtBeer.setText(String.format("%.2f", howMuchBeer(AMOUNTMEN, AMOUNTWOMEN)));
        edtBeer.isFocusable = false;
        edtBeer.isFocusableInTouchMode = false;

        edtSoda.setText(String.format("%.2f", howMuchSoda(AMOUNTMEN, AMOUNTWOMEN, AMOUNTCHILDREN)));
        edtSoda.isFocusable = false;
        edtSoda.isFocusableInTouchMode = false;

        val btnBack = inflate.findViewById<Button>(R.id.btnBack);

        btnBack.setOnClickListener{
            val fm = fragmentManager
            fm!!.beginTransaction()
                .replace(
                    R.id.mainContainer,
                    FormFragment.newInstance(),
                    "ResultadoFragment")
                .addToBackStack(null)
                .commit();
        }

        return inflate;
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: Int, param2: Int, param3: Int) =
            ResultadoFragment().apply {
                arguments = Bundle().apply {
                    AMOUNTMEN = param1;
                    AMOUNTWOMEN = param2;
                    AMOUNTCHILDREN = param3;
                }
            }
    }
}