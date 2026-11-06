package ar.edu.unahur.obj2.agencia.Modificaciones;

import ar.edu.unahur.obj2.agencia.Oferta.Oferta;
import ar.edu.unahur.obj2.agencia.Paquetes.Paquete;

public class SacarOferta implements Modificaciones {
    private Paquete paquete;
    private Oferta oferta;

    public SacarOferta(Paquete paquete, Oferta oferta) {
        this.paquete = paquete;
        this.oferta = oferta;
    }

    @Override
    public void ejecutar() {
        paquete.eliminarOferta(oferta);
    }

    @Override
    public void deshacer() {
        paquete.añadirOferta(oferta);
    }
}
