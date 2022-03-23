package com.columbia.mislugares

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /* Crear interfaz con código */
        /*
            val texto = TextView(this)
            testo.text = "Hola Android"
            setContentView(texto)
         */

        setContentView(R.layout.activity_main)
    }
}