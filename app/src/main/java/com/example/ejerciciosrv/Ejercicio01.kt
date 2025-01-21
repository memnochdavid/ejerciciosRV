package com.example.ejerciciosrv

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejerciciosrv.databinding.ActivityEjercicio01Binding

class Ejercicio01 : AppCompatActivity() {
    private lateinit var binding: ActivityEjercicio01Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityEjercicio01Binding.inflate(layoutInflater)
        setContentView(binding.root)


        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Datos de ejemplo
        val listaContactos = mutableListOf(
            Contacto("Juan", "123456789", "juan@gmail.com", R.drawable.contacto),
            Contacto("Pepe", "123456789", "pepe@gmail.com", R.drawable.contacto),
            Contacto("Sergio", "123456789", "sergio@gmail.com", R.drawable.contacto)
        )

        val adaptador = ContactoAdaptador(listaContactos)

        binding.rv.layoutManager = LinearLayoutManager(this)
        binding.rv.adapter = adaptador
    }
}