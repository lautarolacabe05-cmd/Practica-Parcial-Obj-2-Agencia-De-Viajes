package ar.edu.unahur.obj2.agencia.Servicios;

import ar.edu.unahur.obj2.agencia.Excepciones.TarifaNegativaException;
import ar.edu.unahur.obj2.agencia.Oferta.Oferta;

public class Servicio implements Oferta{
    private double tarifa;
    private String nombre;

    public Servicio(String nombre, double tarifa) {
        this.tarifa = tarifaNoEsNegativa(tarifa);
        this.nombre = nombre;
    }

    private double tarifaNoEsNegativa(double tarifa) {
        if (tarifa < 0) {
            throw new TarifaNegativaException("La tarifa no puede ser negativa");
        }
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifaNoEsNegativa(tarifa);
    }

    @Override 
    public boolean tieneServicio(String nombre) {
        return this.nombre.equals(nombre);
    }
    @Override
    public double getTarifa() {
        return tarifa;
    }
    @Override
    public int cantidadDeServicios() {
        return 1;
    }
    @Override
    public String getDescripcion() {
        return nombre;
    }
}
