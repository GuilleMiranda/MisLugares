package com.columbia.mislugares

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bAcerca = findViewById<Button>(R.id.bAcercaDe)
        bAcerca.setOnClickListener { lanzarAcercaDe(null) }

        val bSalir = findViewById<Button>(R.id.bSalir)
        bSalir.setOnClickListener { salirMenu(null) }
    }

    fun lanzarAcercaDe(view: View?) {
        startActivity(Intent(this, Acerca::class.java))
    }

    fun salirMenu(view: View?) {
        finish()
    }
}