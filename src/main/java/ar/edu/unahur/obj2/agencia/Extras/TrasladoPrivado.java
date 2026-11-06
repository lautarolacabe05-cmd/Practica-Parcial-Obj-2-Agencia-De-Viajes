package ar.edu.unahur.obj2.agencia.Extras;

import ar.edu.unahur.obj2.agencia.Oferta.Oferta;

public class TrasladoPrivado extends Extras {
    public TrasladoPrivado(Oferta oferta) {
        super(oferta);
    }

    @Override
    public String nombreExtra() {
        return "Traslado Privado";
    }

    @Override
    public double tarifaExtra() {
        return 15000;
    }
    
}
