package ar.edu.unahur.obj2.agencia.Oferta;

public interface Oferta {
    double getPrecio();
    String getDescripcion();
    int cantidadDeServicios();
    boolean tieneServicio(String nombre);
}
