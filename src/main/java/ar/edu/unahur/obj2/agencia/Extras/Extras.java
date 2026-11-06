package ar.edu.unahur.obj2.agencia.Extras;

import ar.edu.unahur.obj2.agencia.Oferta.Oferta;

public abstract class Extras implements Oferta {
    protected final Oferta oferta;

    public Extras(Oferta oferta) {
        this.oferta = oferta;
    }

    @Override 
    public double getTarifa() {
        return oferta.getTarifa() + tarifaExtra();
    }
    @Override
    public String getDescripcion() {
        return oferta.getDescripcion() +  " + " + nombreExtra();
    }
    @Override
    public int cantidadDeServicios() {
        return oferta.cantidadDeServicios();
    }
    @Override
    public boolean tieneServicio(String nombre) {
        return oferta.tieneServicio(nombre);
    }

    public abstract String nombreExtra();
    public abstract double tarifaExtra();
}
