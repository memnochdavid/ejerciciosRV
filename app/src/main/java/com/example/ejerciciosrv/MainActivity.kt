package com.example.ejerciciosrv

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejerciciosrv.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        var lista_contactos = mutableListOf<Contacto>(
            Contacto("Juan","123456789","juan@gmail.com",R.drawable.contacto),
            Contacto("Pepe","123456789","juan@gmail.com",R.drawable.contacto),
            Contacto("Sergio","123456789","juan@gmail.com",R.drawable.contacto),
        )
        val binding = ActivityMainBinding.inflate(layoutInflater)

        val adaptador= ContactoAdaptador(lista_contactos)

        binding.rv.layoutManager= LinearLayoutManager(this)
        binding.rv.adapter= adaptador







    }
}