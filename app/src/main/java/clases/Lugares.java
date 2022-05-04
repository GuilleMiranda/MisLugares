package clases;

import com.columbia.mislugares.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Lugares implements Serializable {
  public static List<Lugar> listaLugares = ejemploLugares();

  public Lugares() {
    listaLugares = ejemploLugares();
  }

  public static Lugar elemento(int id) {
    return listaLugares.get(id);
  }

  public static void agregar(Lugar lugar) {
    listaLugares.add(lugar);
  }

  public static int nuevo() {
    Lugar lugar = new Lugar();
    listaLugares.add(lugar);
    return listaLugares.size() - 1;
  }

  public static void borrar(int id) {
    listaLugares.remove(id);
  }

  public static void actualizar(int id, Lugar lugar) {
    listaLugares.add(id, lugar);
  }

  public static int size() {
    return listaLugares.size();
  }

  public static List<Lugar> ejemploLugares() {
    List<Lugar> lugares = new ArrayList<>();

    lugares.add(new Lugar("Universidad Columbia del Paraguay",
        "Avda. España c/ Padre Cardozo, Asunción",
        new GeoPunto(-57.6166526, -25.2870788),
        R.drawable.columbia,
        "+595 21 219 8008",
        "https://www.columbia.edu.py/",
        "La primera, la mejor",
        3,
        TipoLugar.EDUCACION));

    lugares.add(new Lugar(
        "Lido Bar",
        "Manzana T, Cruz del Chaco, Asunción",
        new GeoPunto(-25.3037776, -57.600701),
        R.drawable.lido,
        "+595 21 607 575",
        "http://www.lidobar.com.py/",
        "Buen bar para pasarla con amigos",
        8,
        TipoLugar.BAR
    ));

    lugares.add(new Lugar(
        "Estación de Servicio Petrobras",
        "Avda. Bruno Guggiari, Lambaré",
        new GeoPunto(-25.324415, -57.6189539),
        R.drawable.petrobras,
        "N.E.",
        "N.E.",
        "Mala atención al cliente",
        2,
        TipoLugar.GASOLINERA
    ));

    return lugares;
  }
}
