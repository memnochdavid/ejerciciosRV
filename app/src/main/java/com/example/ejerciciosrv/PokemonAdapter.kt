package com.example.ejerciciosrv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ejerciciosrv.databinding.ObjetoPokemonBinding

class PokemonAdaptador(
    private val lista_pokemon: MutableList<Pokemon>,
    private val lista_capturados: MutableList<Pokemon>,
    private val capturadosAdaptador: PokemonCapturadosAdaptador
) :
    RecyclerView.Adapter<PokemonAdaptador.PokemonViewHolder>() {

    inner class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombre: TextView = itemView.findViewById(R.id.nombre)
        var capturado: CheckBox = itemView.findViewById(R.id.capturado)
        var delete: View = itemView.findViewById(R.id.delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.objeto_pokemon, parent, false)
        return PokemonViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return lista_pokemon.size
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon_actual = lista_pokemon[position]
        holder.nombre.text = pokemon_actual.nombre
        holder.capturado.isChecked = pokemon_actual.capturado
        holder.capturado.setOnCheckedChangeListener { _, isChecked ->
            pokemon_actual.capturado = isChecked
            if (isChecked) {
                // Move to captured list
                lista_capturados.add(pokemon_actual)
                lista_pokemon.removeAt(position) // Remove from original list
                notifyItemRemoved(position) // Notify that an item was removed
                capturadosAdaptador.notifyDataSetChanged() // Update the captured list
                notifyItemChanged(position)
            } else {
                // Move back to the original list
                lista_pokemon.add(pokemon_actual)
                lista_capturados.remove(pokemon_actual)
                notifyItemChanged(position)
                capturadosAdaptador.notifyDataSetChanged()
            }
        }
        holder.delete.setOnClickListener {
            lista_pokemon.removeAt(position)
            notifyItemRemoved(position)
            capturadosAdaptador.notifyDataSetChanged()
        }
    }
}
class PokemonCapturadosAdaptador(private val lista_capturados: MutableList<Pokemon>) :
    RecyclerView.Adapter<PokemonCapturadosAdaptador.PokemonViewHolder>() {

    inner class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombre: TextView = itemView.findViewById(R.id.nombre)
        var capturado: CheckBox = itemView.findViewById(R.id.capturado)
        var delete: View = itemView.findViewById(R.id.delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.objeto_pokemon, parent, false)
        return PokemonViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return lista_capturados.size
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon_actual = lista_capturados[position]
        holder.nombre.text = pokemon_actual.nombre
        holder.capturado.isChecked = pokemon_actual.capturado
        holder.capturado.setOnCheckedChangeListener { _, isChecked ->
            pokemon_actual.capturado = isChecked
            if (!isChecked) {
                lista_capturados.remove(pokemon_actual)
            }
            notifyItemChanged(position)
        }
        holder.delete.setOnClickListener {
            lista_capturados.removeAt(position)
            notifyItemRemoved(position)
        }
    }
}