package com.upao.crimenintent.presentacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.upao.crimenintent.R

    class MainActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_crime) // Configura el layout de Activity_crime

            // Cargar CrimenFragment en el contenedor_fragmento
            val crimenFragment = CrimenFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.contenedor_fragmento, crimenFragment)
                .commit()

            // Cargar CrimenListaFragment en el contenedor_lista_fragmento
            val crimenListaFragment = CrimenListaFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.contenedor_lista_fragmento, crimenListaFragment)
                .commit()
        }
}