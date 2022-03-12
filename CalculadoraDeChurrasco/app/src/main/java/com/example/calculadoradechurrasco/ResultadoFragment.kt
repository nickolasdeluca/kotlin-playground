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

private const val ARG_PARAM1 = "0";
private const val ARG_PARAM2 = "0";
private const val ARG_PARAM3 = "0";

class ResultadoFragment : Fragment() {
    private var param1: Int = 0;
    private var param2: Int = 0;
    private var param3: Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        arguments?.let {
            param1 = it.getInt(ARG_PARAM1);
            param2 = it.getInt(ARG_PARAM2);
            param3 = it.getInt(ARG_PARAM3);
        }
    }

    fun howManySausages(amountMen: Int, amountWomen: Int, amountChildren: Int): Double {
        return amountMen.times(200).plus(amountWomen.times(180)).plus(amountChildren.times(100)).toDouble();
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflate = inflater.inflate(R.layout.fragment_resultado, container, false);

        val edtSausages = inflate.findViewById<EditText>(R.id.edtSausage);

        val amountMen = param1.toInt();
        val amountWomen = param2.toInt();
        val amountChildren = param3.toInt();

        edtSausages.setText(String.format("%.2f", howManySausages(amountMen, amountWomen, amountChildren)));

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
                    putInt(ARG_PARAM1, param1);
                    putInt(ARG_PARAM2, param2);
                    putInt(ARG_PARAM3, param3);
                }
            }
    }
}