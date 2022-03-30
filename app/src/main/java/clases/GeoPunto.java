package clases;

import java.io.Serializable;

public class GeoPunto implements Serializable {
    private double longitud;
    private double latitud;

    public GeoPunto() {
    }

    public GeoPunto(double longitud, double latitud) {
        this.longitud = longitud;
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    @Override
    public String toString() {
        return "GeoPunto{" +
                "longitud=" + longitud +
                ", latitud=" + latitud +
                '}';
    }
}
