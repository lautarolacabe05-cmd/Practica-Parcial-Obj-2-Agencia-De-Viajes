package ar.edu.unahur.obj2.agencia.Extras;

import ar.edu.unahur.obj2.agencia.Oferta.Oferta;

public abstract class Extras implements Oferta {
    protected final Oferta oferta;

    public Extras(Oferta oferta) {
        this.oferta = oferta;
    }

    @Override 
    public double getPrecio() {
        return oferta.getPrecio() + precioExtra();
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
    public abstract double precioExtra();
}
