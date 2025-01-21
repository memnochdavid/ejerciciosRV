package com.example.ejerciciosrv

import android.content.Intent
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
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.boton1.setOnClickListener {
            val intent = Intent(this, Ejercicio01::class.java)
            startActivity(intent)
        }
        binding.boton2.setOnClickListener {
            val intent = Intent(this, Ejercicio02::class.java)
            startActivity(intent)
        }
        binding.boton3.setOnClickListener {
            val intent = Intent(this, Ejercicio03::class.java)
            startActivity(intent)
        }


    }
}