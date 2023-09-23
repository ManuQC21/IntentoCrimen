package com.upao.crimenintent.presentacion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.upao.crimenintent.databinding.FragmentCrimenListaBinding
import com.upao.crimenintent.modelo.Crimen
import java.util.Date
import java.util.UUID

class CrimenListaFragment : Fragment() {
    private var _binding: FragmentCrimenListaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCrimenListaBinding.inflate(inflater, container, false)
        val view = binding.root

        val listaCrimenes = getListaFicticiaDeCrimenes()

        // El linear para el Recly osea para la colexión de listas
        val layoutManager = LinearLayoutManager(context)
        binding.recyclerViewCrimenes.layoutManager = layoutManager

        // Adaptador para la lista
        val crimenAdapter = CrimenAdapter(listaCrimenes)
        binding.recyclerViewCrimenes.adapter = crimenAdapter

        return view
    }

    private fun getListaFicticiaDeCrimenes(): List<Crimen> {
        val listaCrimenes = mutableListOf<Crimen>()

        listaCrimenes.add(
            Crimen(
                UUID.randomUUID(),
                "Asalto a mano armada",
                Date(),
                true
            )
        )
        listaCrimenes.add(
            Crimen(
                UUID.randomUUID(),
                "Robo de auto",
                Date(),
                true
            )
        )
        listaCrimenes.add(
            Crimen(
                UUID.randomUUID(),
                "Vandalismo",
                Date(),
                false
            )
        )
        listaCrimenes.add(
            Crimen(
                UUID.randomUUID(),
                "Homicidio",
                Date(),
                true
            )
        )
        listaCrimenes.add(
            Crimen(
                UUID.randomUUID(),
                "Robo en tienda",
                Date(),
                true
            )
        )

        return listaCrimenes
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
