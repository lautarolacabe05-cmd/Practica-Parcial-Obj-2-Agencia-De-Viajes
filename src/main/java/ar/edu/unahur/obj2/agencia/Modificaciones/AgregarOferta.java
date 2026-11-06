package ar.edu.unahur.obj2.agencia.Modificaciones;

import ar.edu.unahur.obj2.agencia.Oferta.Oferta;
import ar.edu.unahur.obj2.agencia.Paquetes.Paquete;

public class AgregarOferta implements Modificaciones {
    private Paquete paquete;
    private Oferta oferta;

    public AgregarOferta(Paquete paquete, Oferta oferta) {
        this.paquete = paquete;
        this.oferta = oferta;
    }

    @Override
    public void ejecutar() {
        paquete.añadirOferta(oferta);
    }

    @Override
    public void deshacer() {
        paquete.eliminarOferta(oferta);
    }
    
}
