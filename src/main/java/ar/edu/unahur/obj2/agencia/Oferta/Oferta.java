package ar.edu.unahur.obj2.agencia.Oferta;

public interface Oferta {
    double getTarifa();
    String getDescripcion();
    int cantidadDeServicios();
    boolean tieneServicio(String nombre);
}
