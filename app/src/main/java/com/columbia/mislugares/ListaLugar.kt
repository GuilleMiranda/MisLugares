package com.columbia.mislugares

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import clases.Lugares

class ListaLugar : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.lista_lugar)

    val adaptadorLugar = LugarAdaptador(this)

    val lvLugar = findViewById<ListView>(R.id.lvLugar)
    lvLugar.adapter = adaptadorLugar

    lvLugar.setOnItemClickListener { _, _, position, _ -> vistaLugar(position) }
  }

  private fun vistaLugar(posicion: Int) {

    val i = Intent(this, VistaLugar::class.java)
    i.putExtra("Lugar", Lugares.listaLugares[posicion])
    i.putExtra("Posicion", posicion)
    startActivity(i)
  }
}