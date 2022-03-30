package clases;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Lugar implements Serializable {

  private String nombre;
  private String direccion;
  private GeoPunto posicion;
  private int foto;
  private String telefono;
  private String url;
  private String comentario;
  private String fecha;
  private int valoracion;
  private TipoLugar tipoLugar;

  public Lugar() {
    fecha = obtenerFechaActual();
    posicion = new GeoPunto(0, 0);
    tipoLugar = TipoLugar.OTROS;
  }

  public Lugar(String nombre,
               String direccion,
               GeoPunto posicion,
               int foto,
               String telefono,
               String url,
               String comentario,
               int valoracion,
               TipoLugar tipoLugar) {
    this.nombre = nombre;
    this.direccion = direccion;
    this.posicion = posicion;
    this.foto = foto;
    this.telefono = telefono;
    this.url = url;
    this.comentario = comentario;
    this.fecha = obtenerFechaActual();
    this.valoracion = valoracion;
    this.tipoLugar = tipoLugar;
  }

  // class methods
  private String obtenerFechaActual() {
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
    return dateFormat.format(new Date());
  }

  // getters and setters
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public GeoPunto getPosicion() {
    return posicion;
  }

  public void setPosicion(GeoPunto posicion) {
    this.posicion = posicion;
  }

  public int getFoto() {
    return foto;
  }

  public void setFoto(int foto) {
    this.foto = foto;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getComentario() {
    return comentario;
  }

  public void setComentario(String comentario) {
    this.comentario = comentario;
  }

  public String getFecha() {
    return fecha;
  }

  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  public int getValoracion() {
    return valoracion;
  }

  public void setValoracion(int valoracion) {
    this.valoracion = valoracion;
  }

  public TipoLugar getTipoLugar() {
    return tipoLugar;
  }

  public void setTipoLugar(TipoLugar tipoLugar) {
    this.tipoLugar = tipoLugar;
  }

  @Override
  public String toString() {
    return "Lugar{" +
        "nombre='" + nombre + '\'' +
        ", direccion='" + direccion + '\'' +
        ", posicion=" + posicion +
        ", foto=" + foto +
        ", telefono='" + telefono + '\'' +
        ", url='" + url + '\'' +
        ", comentario='" + comentario + '\'' +
        ", fecha='" + fecha + '\'' +
        ", valoracion=" + valoracion +
        ", tipoLugar=" + tipoLugar +
        '}';
  }
}
