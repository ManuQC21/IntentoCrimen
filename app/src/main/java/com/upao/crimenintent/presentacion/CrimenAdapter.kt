package com.upao.crimenintent.presentacion

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.upao.crimenintent.R
import com.upao.crimenintent.modelo.Crimen
import com.upao.crimenintent.databinding.ItemCrimenBinding

class CrimenAdapter(private val listaCrimenes: List<Crimen>) :
    RecyclerView.Adapter<CrimenAdapter.CrimenViewHolder>() {

    inner class CrimenViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemCrimenBinding.bind(itemView)

        fun bind(crimen: Crimen) {
            binding.tvTituloCrimen.text = crimen.titulo
            binding.tvFechaCrimen.text = crimen.fecha.toString()

            // Si es True sale resuelto, si es falso sale no resuelto
            val estadoResuelto = if (crimen.resuelto) "Resuelto" else "No resuelto"
            binding.tvDetalleCrimen.text = estadoResuelto
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimenViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_crimen, parent, false)
        return CrimenViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CrimenViewHolder, position: Int) {
        val crimen = listaCrimenes[position]
        holder.bind(crimen)
    }

    override fun getItemCount(): Int {
        return listaCrimenes.size
    }
}