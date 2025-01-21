package com.example.ejerciciosrv

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejerciciosrv.databinding.ActivityEjercicio03Binding

class Ejercicio03 : AppCompatActivity() {
    private lateinit var binding: ActivityEjercicio03Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio03Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val lista_pokemon = mutableListOf(
            Pokemon("Pikachu", false),
            Pokemon("Bulbasaur", false),
            Pokemon("Charmander", false),
            Pokemon("Squirtle", false),
            Pokemon("Caterpie", false),
        )
        val lista_capturados = mutableListOf<Pokemon>()

        val adaptador = PokemonAdaptador(lista_pokemon, lista_capturados, PokemonCapturadosAdaptador(lista_capturados))
        val adaptadorCapturados = PokemonCapturadosAdaptador(lista_capturados)

        binding.rv3.layoutManager = LinearLayoutManager(this)
        binding.rv3.adapter = adaptador

        binding.rv4.layoutManager = LinearLayoutManager(this)
        binding.rv4.adapter = adaptadorCapturados

        binding.add.setOnClickListener {
            if (binding.textInputEditText.text.toString() != "") {
                lista_pokemon.add(Pokemon(binding.textInputEditText.text.toString(), false))
                adaptador.notifyItemInserted(lista_pokemon.size - 1)
                binding.textInputEditText.text?.clear()
            }
        }
    }
}