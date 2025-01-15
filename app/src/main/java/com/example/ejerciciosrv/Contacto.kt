package com.example.ejerciciosrv

import android.graphics.drawable.Drawable

class Contacto(
    var nombre:String,
    var telefono:String,
    var correo:String,
    var foto: Int
){
    init {
        foto = R.drawable.contacto
    }
}