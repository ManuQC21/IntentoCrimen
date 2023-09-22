package com.upao.crimenintent.presentacion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.upao.crimenintent.modelo.Crimen
import java.util.Date
import java.util.UUID
import com.upao.crimenintent.databinding.FragmentCrimenBinding

class CrimenFragment : Fragment()   {
    private lateinit var crimen:Crimen
    private var _binding:FragmentCrimenBinding?=null
    private val binding
        get()= checkNotNull(_binding){

        }


    override fun onCreate(savedInstanceState: Bundle?){
            super.onCreate(savedInstanceState)
            crimen=Crimen(id= UUID.randomUUID(), titulo = "", fecha = Date(),resuelto = false)
    }
    override fun onCreateView(
        inflater: LayoutInflater,container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        _binding = FragmentCrimenBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            txtTituloCrimen.doOnTextChanged{texto,_,_,_ ->
                crimen=crimen.copy(titulo = texto.toString())
            }
            btnFechaCrimen.apply {
                text=crimen.fecha.toString()
                isEnabled=true
            }
            chkCrimenResuelto.setOnCheckedChangeListener(){_,seleccionado ->
                crimen=crimen.copy(resuelto=seleccionado)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }


    }
