package com.example.ejerciciosrv

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class ContactoAdaptador(private val lista_contactos: MutableList<Contacto>) :
    RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder>() {

    inner class ContactoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombre: TextView = itemView.findViewById(R.id.nombre)
        val telefono: TextView = itemView.findViewById(R.id.telefono)
        val email: TextView = itemView.findViewById(R.id.email)
        val foto: ImageView = itemView.findViewById(R.id.foto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactoViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.objeto_contacto, parent, false)
        return ContactoViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return lista_contactos.size
    }

    override fun onBindViewHolder(holder: ContactoViewHolder, position: Int) {
        val contacto_actual = lista_contactos[position]
        holder.nombre.text = contacto_actual.nombre
        holder.email.text=contacto_actual.correo
        holder.telefono.text=contacto_actual.telefono
        holder.foto.setImageResource(contacto_actual.foto)
    }




}