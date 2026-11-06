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
    public double tarifaExtra() {
        return oferta.getTarifa() * 1.1;
    }
    
}
