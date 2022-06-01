package com.columbia.mislugares

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import clases.Lugar
import clases.Lugares
import clases.TipoLugar

class RegistrarLugar : AppCompatActivity() {
  private lateinit var lugar: Lugar
  private lateinit var etNombre: EditText
  private lateinit var sTipo: Spinner
  private lateinit var etDireccion: EditText
  private lateinit var etTelefono: EditText
  private lateinit var etUrl: EditText
  private lateinit var etComentario: EditText

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.registrar_lugar)

    etNombre = findViewById(R.id.etNombreRL)
    sTipo = findViewById(R.id.sTipoRL)
    val adaptador =
      ArrayAdapter(this, android.R.layout.simple_spinner_item, TipoLugar.obtenerTiposLugares())
    adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

    sTipo.adapter = adaptador
    etDireccion = findViewById(R.id.etDireccionRL)
    etTelefono = findViewById(R.id.etTelefonoRL)
    etUrl = findViewById(R.id.etUrlRL)
    etComentario = findViewById(R.id.etComentarioRL)
    lugar = Lugar()
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.registrar_lugar, menu)
    return super.onCreateOptionsMenu(menu)
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    return when (item.itemId) {
      R.id.accion_cancelar_rl -> {
        val i = intent
        setResult(RESULT_CANCELED, i)
        finish()
        true
      }
      R.id.accion_guardar_rl -> {
        guardarCambios()
        true
      }
      else -> super.onOptionsItemSelected(item)
    }
  }

  private fun guardarCambios() {
    lugar.nombre = etNombre.text.toString()
    lugar.tipoLugar = TipoLugar.values()[sTipo.selectedItemPosition]
    lugar.direccion = etDireccion.text.toString()
    lugar.telefono = etTelefono.text.toString()
    lugar.url = etUrl.text.toString()
    lugar.comentario = etComentario.text.toString()
    Lugares.agregar(lugar)
    val i = intent
    i.putExtra("Lugar", lugar)
    setResult(RESULT_OK, i)
    finish()
  }
}