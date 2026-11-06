package ar.edu.unahur.obj2.agencia.Paquetes;
import ar.edu.unahur.obj2.agencia.Servicios.ExcursionPeritoMoreno;
import ar.edu.unahur.obj2.agencia.Servicios.*;
import ar.edu.unahur.obj2.agencia.Servicios.VueloBarilocheACalafate;

public class AventuraPatagonica extends Paquete {
    public AventuraPatagonica() {
        super("Aventura Patagonica", 20);
        añadirServicio(new BarilocheClasico());
        añadirServicio(new VueloBarilocheACalafate());
        añadirServicio(new CalafateGlaciares());
        añadirServicio(new VueloCalafateABuenosAires());
    }
}
