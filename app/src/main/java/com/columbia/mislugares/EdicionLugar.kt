package com.columbia.mislugares

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import clases.Lugar
import clases.TipoLugar

class EdicionLugar : AppCompatActivity() {
    private lateinit var lugar: Lugar
    private var posicion = 0
    private lateinit var etNombre: EditText
    private lateinit var sTipo: Spinner
    private lateinit var etDireccion: EditText
    private lateinit var etTelefono: EditText
    private lateinit var etUrl: EditText
    private lateinit var etComentario: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edicion_lugar)

        val i = intent
        lugar = i.getSerializableExtra("Lugar") as Lugar
        posicion = i.getIntExtra("Posicion", -1)
        etNombre = findViewById(R.id.etNombre)
        etNombre.setText(lugar.nombre)
        sTipo = findViewById(R.id.sTipo)
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, TipoLugar.obtenerTiposLugares())
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sTipo.adapter = adaptador
        sTipo.setSelection(lugar.tipoLugar.ordinal)

        etDireccion = findViewById(R.id.etDireccion)
        etDireccion.setText(lugar.direccion)

        etTelefono = findViewById(R.id.etTelefono)
        etTelefono.setText(lugar.telefono)

        etUrl = findViewById(R.id.etUrl)
        etUrl.setText(lugar.url)

        etComentario = findViewById(R.id.etComentario)
        etComentario.setText(lugar.comentario)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.edicion_lugar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.accion_guardar -> {
                guardarCambios()
                true
            }
            R.id.accion_cancelar -> {
                cancelar()
                true
            } else -> super.onOptionsItemSelected(item)
        }
    }

    private fun guardarCambios() {
        lugar.nombre = etNombre.text.toString()
        lugar.tipoLugar = TipoLugar.values()[sTipo.selectedItemPosition]
        lugar.direccion = etDireccion.text.toString()
        lugar.telefono = etTelefono.text.toString()
        lugar.url = etUrl.text.toString()
        lugar.comentario = etComentario.text.toString()

        val i = intent
        i.putExtra("Lugar", lugar)
        setResult(RESULT_OK, i)
        finish()
    }

    fun cancelar () {
        val i = intent
        setResult(RESULT_CANCELED, i)
        finish()
    }
}