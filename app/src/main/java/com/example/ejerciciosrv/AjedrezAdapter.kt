package com.example.ejerciciosrv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AjedrezAdaptador(private val lista_piezas: MutableList<PiezaAjedrez>) :
    RecyclerView.Adapter<AjedrezAdaptador.AjedrezViewHolder>() {

    inner class AjedrezViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombre: TextView = itemView.findViewById(R.id.nombre)
        val foto: ImageView = itemView.findViewById(R.id.foto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AjedrezViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.objeto_pieza_ajedrez, parent, false)
        return AjedrezViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return lista_piezas.size
    }

    override fun onBindViewHolder(holder: AjedrezViewHolder, position: Int) {
        val pieza_actual = lista_piezas[position]
        holder.nombre.text = pieza_actual.nombre
        holder.foto.setImageResource(pieza_actual.foto)
    }
}