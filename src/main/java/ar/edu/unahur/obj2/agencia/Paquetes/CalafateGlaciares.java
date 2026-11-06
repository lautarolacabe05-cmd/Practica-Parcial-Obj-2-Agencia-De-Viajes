package ar.edu.unahur.obj2.agencia.Paquetes;

import ar.edu.unahur.obj2.agencia.Servicios.ExcursionPeritoMoreno;
import ar.edu.unahur.obj2.agencia.Servicios.HotelGlaciares;

public class CalafateGlaciares extends Paquete {
    public CalafateGlaciares() {
        super("Calafate Glaciares", 5);
        añadirServicio(new HotelGlaciares());
        añadirServicio(new ExcursionPeritoMoreno());
    }
}
