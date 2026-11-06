package ar.edu.unahur.obj2.agencia.Extras;

import ar.edu.unahur.obj2.agencia.Oferta.Oferta;

public class SeguroDeCancelacion extends Extras {
    public SeguroDeCancelacion(Oferta oferta) {
        super(oferta);
    }

    @Override
    public String nombreExtra() {
        return "Seguro de Cancelación";
    }

    @Override
    public double precioExtra() {
        return oferta.getPrecio() * 1.1;
    }
    
}
