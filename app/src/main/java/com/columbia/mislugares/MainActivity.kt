package com.columbia.mislugares

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import clases.Lugares

class MainActivity : AppCompatActivity() /*View.OnClickListener*/{
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val bAcerca = findViewById<Button>(R.id.bAcercaDe)
    bAcerca.setOnClickListener { lanzarAcercaDe() }

    val bSalir = findViewById<Button>(R.id.bSalir)
    bSalir.setOnClickListener { salirMenu() }

    val bMostrar = findViewById<Button>(R.id.bMostrar)
    bMostrar.setOnClickListener {
      abrirVistaLugar(1)
//            mostrarLugares()
    }
  }

  private fun lanzarAcercaDe() {
    startActivity(Intent(this, Acerca::class.java))
  }

  private fun salirMenu() {
    finish()
  }

  private fun abrirVistaLugar(posicion: Int) {
    val i = Intent(this, VistaLugar::class.java)
    i.putExtra("Lugar", Lugares.listaLugares[posicion])
    i.putExtra("Posicion", posicion)
    startActivity(i)
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.activity_main, menu)
    return super.onCreateOptionsMenu(menu)
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    return when (item.itemId) {
      R.id.accion_acerca -> {
        lanzarAcercaDe()
        true
      }
      else -> super.onOptionsItemSelected(item)
    }
  }

  /*
  * override fun onClick(p0: View?) {
  *   if (p0.id == bInicia.id) ...
  * }
  * */
}