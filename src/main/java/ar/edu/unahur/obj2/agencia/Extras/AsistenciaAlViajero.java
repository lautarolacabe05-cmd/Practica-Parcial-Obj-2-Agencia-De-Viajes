package ar.edu.unahur.obj2.agencia.Extras;

import ar.edu.unahur.obj2.agencia.Oferta.Oferta;

public class AsistenciaAlViajero extends Extras {
    public AsistenciaAlViajero(Oferta oferta) {
        super(oferta);
    }

    @Override
    public String nombreExtra() {
        return "Asistencia al Viajero";
    }

    @Override
    public double precioExtra() {
        return 8000;
    }
    
}
