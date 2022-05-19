package com.columbia.mislugares

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import clases.Lugares

class LugarAdaptador(val context: Context) : BaseAdapter() {
  override fun getCount(): Int {
    return Lugares.size()
  }

  override fun getItem(position: Int): Any {
    return Lugares.elemento(position)
  }

  override fun getItemId(position: Int): Long {
    return position.toLong()
  }

  override fun getView(position: Int, convertView: View?, p2: ViewGroup?): View {
    val inflador: LayoutInflater =
      context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    val lugar = Lugares.elemento(position)
    val layout = inflador.inflate(R.layout.elemento_lista, null)
    val tvNombre = layout?.findViewById<TextView>(R.id.textView2)
    tvNombre?.text = lugar.nombre
    val tvDireccion = layout?.findViewById<TextView>(R.id.textView3)
    tvDireccion?.text = lugar.direccion
    val rbValoracion = layout?.findViewById<RatingBar>(R.id.ratingBar2)
    rbValoracion?.rating = lugar.valoracion.toFloat()
    val ivTipoLugar = layout?.findViewById<ImageView>(R.id.imageView)
    val foto = lugar.tipoLugar.recurso
    ivTipoLugar?.setImageResource(foto)
    ivTipoLugar?.scaleType = ImageView.ScaleType.FIT_END
    return layout
  }
}

/*
//    val foto = when (lugar.tipoLugar) {
//      TipoLugar.BAR -> R.drawable.bar
//      TipoLugar.COPAS -> R.drawable.copas
//      TipoLugar.ESPECTACULO ->R.drawable.espectaculos
//      TipoLugar.HOTEL -> R.drawable.hotel
//      TipoLugar.COMPRAS -> R.drawable.compras
//      TipoLugar.EDUCACION -> R.drawable.educacion
//      TipoLugar.DEPORTE -> R.drawable.deporte
//      TipoLugar.NATURALEZA -> R.drawable.naturaleza
//      TipoLugar.GASOLINERA -> R.drawable.gasolinera
//      else -> R.drawable.otros
//    }*/