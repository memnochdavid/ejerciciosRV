package com.example.ejerciciosrv

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejerciciosrv.databinding.ActivityEjercicio02Binding

class Ejercicio02 : AppCompatActivity() {
    private lateinit var binding: ActivityEjercicio02Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEjercicio02Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val piezas_ajedrez = mutableListOf(
            PiezaAjedrez("Rey", R.drawable.king),
            PiezaAjedrez("Alfil", R.drawable.bishop),
            PiezaAjedrez("Torre", R.drawable.rook),
            PiezaAjedrez("Reina", R.drawable.queen),
            PiezaAjedrez("Peon", R.drawable.pawn),
            PiezaAjedrez("Caballo", R.drawable.knight),
        )

        val adaptador = AjedrezAdaptador(piezas_ajedrez)

        binding.rv2.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rv2.adapter = adaptador

    }
}