package com.columbia.mislugares

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.TestLooperManager
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
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

        val lltelefono  = findViewById<LinearLayout>(R.id.llTelefono)
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

        val dateFormat :DateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.US)
        var date : Date? = null
        try{
            date = dateFormat.parse(lugar.fecha)
        }catch (e: ParseException){
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


}