package ar.edu.unahur.obj2.agencia.Paquetes;

import ar.edu.unahur.obj2.agencia.Servicios.ExcursionCerroCatedral;
import ar.edu.unahur.obj2.agencia.Servicios.HotelLlaoLlao;
import ar.edu.unahur.obj2.agencia.Servicios.VueloBuenosAiresBariloche;

public class BarilocheClasico extends Paquete {
    public BarilocheClasico() {
        super("Bariloche Clasico", 10);
        añadirServicio(new VueloBuenosAiresBariloche());
        añadirServicio(new ExcursionCerroCatedral());
        añadirServicio(new HotelLlaoLlao());
    }
    
}
