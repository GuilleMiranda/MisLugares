package com.columbia.mislugares

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import clases.Lugar
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class VistaLugar : AppCompatActivity() {
  private lateinit var lugar: Lugar
  private var posicion = 0
  private lateinit var ivFoto: ImageView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.vista_lugar)

    val i = intent
    lugar = i?.getSerializableExtra("Lugar") as Lugar
    posicion = i.getIntExtra("Posicion", -1)

    val tvNombreLugar = findViewById<TextView>(R.id.tvNombreLugar)
    tvNombreLugar.text = lugar.nombre

    val ivTipoLugar = findViewById<ImageView>(R.id.ivTipoLugar)
    ivTipoLugar.setImageResource(lugar.tipoLugar.recurso)

    val tvTipoLugar = findViewById<TextView>(R.id.tvTipoLugar)
    tvTipoLugar.text = lugar.tipoLugar.texto

    val tvDireccion = findViewById<TextView>(R.id.tvDireccion)
    tvDireccion.text = lugar.direccion

    val lltelefono = findViewById<LinearLayout>(R.id.llTelefono)
    if (lugar.telefono.equals("N.E.")) {
      lltelefono.visibility = View.GONE
    } else {
      val tvTelefono = findViewById<TextView>(R.id.tvTelefono)
      tvTelefono.text = lugar.telefono
    }

    val tvUrl = findViewById<TextView>(R.id.tvUrl)
    tvUrl.text = lugar.url

    val tvComentario = findViewById<TextView>(R.id.tvComentario)
    tvComentario.text = lugar.comentario

    val dateFormat: DateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.US)
    var date: Date? = null
    try {
      date = dateFormat.parse(lugar.fecha)
    } catch (e: ParseException) {
      e.printStackTrace()
    }

    val tvFecha = findViewById<TextView>(R.id.tvFecha)
    tvFecha.text = DateFormat.getDateInstance().format(date)

    val tvHora = findViewById<TextView>(R.id.tvHora)
    tvHora.text = DateFormat.getTimeInstance().format(date)

    val rbValoracion = findViewById<RatingBar>(R.id.rbValoracion)
    rbValoracion.rating = lugar.valoracion.toFloat()

    ivFoto = findViewById(R.id.ivFoto)
    ivFoto.setImageResource(lugar.foto)
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.vista_lugar, menu)
    return super.onCreateOptionsMenu(menu)
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    return when (item.itemId) {
      R.id.accion_compartir -> {
        compartir()
        true
      }
      R.id.accion_llegar -> {
        //mapa()
        true
      }
      R.id.accion_editar -> {
        //editarLugar()
        true
      }
      R.id.accion_borrar -> {
        abrirDialogo()
        true
      }
      else -> super.onOptionsItemSelected(item)
    }
  }

  private fun compartir() {
    val info = lugar.toString()
    val shareIntent = Intent()
    shareIntent.action = Intent.ACTION_SEND
    shareIntent.type = "text/plain"
    shareIntent.putExtra(Intent.EXTRA_TEXT, info)
    startActivity(Intent.createChooser(shareIntent, "Compartir por"))
  }

//  private fun mapa() {
//    val i = Intent(this, MapsActivity::class.java)
//    i.putExtra("Lugar", lugar)
//    startActivity(i)
//  }

  private fun abrirDialogo() {
    AlertDialog.Builder(this).setTitle("Borrado de lugar")
      .setMessage("¿Está seguro de que desea eliminar este lugar?")
      .setPositiveButton("Confirmar") { dialog, whichButton -> borrarLugar() }
      .setNegativeButton("Cancelar", null).show()
  }

  private fun borrarLugar() {
    null;
  }
}