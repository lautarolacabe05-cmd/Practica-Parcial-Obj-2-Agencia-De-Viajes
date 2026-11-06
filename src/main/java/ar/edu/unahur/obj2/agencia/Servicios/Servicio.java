package ar.edu.unahur.obj2.agencia.Servicios;

import ar.edu.unahur.obj2.agencia.Excepciones.TarifaNegativaException;

public abstract class Servicio {
    private double tarifa;
    private String nombre;

    public Servicio(double tarifa, String nombre) {
        this.tarifa = tarifaNoEsNegativa(tarifa);
        this.nombre = nombre;
    }

    private double tarifaNoEsNegativa(double tarifa) {
        if (tarifa < 0) {
            throw new TarifaNegativaException("La tarifa no puede ser negativa");
        }
        return tarifa;
    }

    public double getTarifa() {
        return tarifa;
    }
    public boolean tieneServicio(String nombre) {
        return this.nombre.equals(nombre);
    }
    public int cantidadDeServicios() {
        return 1;
    }

    public String getDescripcion() {
        return nombre;
    }
}
