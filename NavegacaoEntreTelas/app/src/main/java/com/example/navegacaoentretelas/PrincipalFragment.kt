package com.example.navegacaoentretelas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [PrincipalFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PrincipalFragment : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val inflate = inflater.inflate(R.layout.fragment_principal, container, false)

        val goToButton = inflate.findViewById<Button>(R.id.button)

        val texto1 = inflate.findViewById<EditText>(R.id.edt1)

        val texto2 = inflate.findViewById<EditText>(R.id.edt2)

        val texto3 = inflate.findViewById<EditText>(R.id.edt3)

        goToButton.setOnClickListener{
            val fm = fragmentManager
            fm!!.beginTransaction()
                .replace(R.id.fragmentContainer, DetalheFragment.newInstance(
                    texto1.text.toString(),
                    texto2.text.toString(),
                    texto3.text.toString(),
                ),"DetalheFragment")
                .addToBackStack(null).commit()
        }

        return inflate
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment PrincipalFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) = PrincipalFragment().apply { }
    }
}