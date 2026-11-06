package ar.edu.unahur.obj2.agencia.Paquetes;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.agencia.Excepciones.DescuentoInvalidoException;
import ar.edu.unahur.obj2.agencia.Excepciones.TarifaNegativaException;
import ar.edu.unahur.obj2.agencia.Oferta.Oferta;

public class Paquete implements Oferta {
    private final List<Oferta> packOfertas;
    private String nombre;
    private double descuento;

    public Paquete(String nombre, double descuento,Oferta... ofertas) {
        this.packOfertas = new ArrayList<>(List.of(ofertas));
        this.nombre = nombre;
        this.descuento = descuentoEsValido(descuento);

    }
    @Override 
    public double getPrecio() {
        double precioTotal = 0;
        for (Oferta oferta : packOfertas) {
            precioTotal += oferta.getPrecio();
        }
        return precioTotal * (1 - descuento / 100);
    }
    @Override 
    public int cantidadDeServicios() {
        int totalServicios = 0;
        for (Oferta oferta : packOfertas) {
            totalServicios += oferta.cantidadDeServicios();
        }
        return totalServicios;
    }
    public final double descuentoEsValido(double descuento) {
        if (descuento < 0 || descuento > 100) {
            throw new DescuentoInvalidoException("El descuento debe estar entre 0 y 100");
        }
        return descuento;
    }
     
    public double getDescuento() {
        return descuento;
    }
    @Override 
    public boolean tieneServicio(String nombre) {
        for (Oferta oferta : packOfertas) {
            if (oferta.tieneServicio(nombre)) {
                return true;
            }
        }
        return false;
    }
    public final double tarifaNoEsNegativa(double precio) {
        if (precio < 0) {
            throw new TarifaNegativaException("El precio no puede ser negativo");
        }
        return precio;
    }

    public List<Oferta> getOfertas() {
        return packOfertas;
    }

    public void añadirOferta(Oferta oferta) {
        packOfertas.add(oferta);
    }
    @Override
    public String getDescripcion() {
        return nombre;
    }
}
