package com.example.rubricatelefonica

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.rubricatelefonica.data.ContattiDatabase
import com.example.rubricatelefonica.data.Contatto
import com.example.rubricatelefonica.data.RubricaDao
import kotlinx.android.synthetic.main.fragment_addfragment.*
import kotlinx.android.synthetic.main.fragment_addfragment.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [addfragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class addfragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var dao: RubricaDao
    private lateinit var viewModel: addViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dao = ContattiDatabase.getInstance(requireContext()).getRubricaDao()
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel=ViewModelProvider(this).get(addViewModel::class.java)
        val view=inflater.inflate(R.layout.fragment_addfragment,container,false)

        view.aggiungi.setOnClickListener{
            InserisciData()
            findNavController().navigate(R.id.action_addfragment_to_listafragment)

        }
        // Inflate the layout for this fragment
        return view
    }

    private fun InserisciData() {
        val nome=nome.text.toString()
        val cognome=cognome.text.toString()
        val numero=numero.text.toString()
        val email=email.text.toString()
        val contatto=Contatto(nome,cognome,numero,email)
        viewModel.addContatto(contatto)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment addfragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            addfragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}