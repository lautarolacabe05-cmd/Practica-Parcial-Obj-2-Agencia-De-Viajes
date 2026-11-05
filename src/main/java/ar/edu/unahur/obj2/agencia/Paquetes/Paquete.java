package ar.edu.unahur.obj2.agencia.Paquetes;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.agencia.Excepciones.*;
import ar.edu.unahur.obj2.agencia.Servicios.Servicio;

public abstract class Paquete {
    private final List<Servicio> servicios;
    private String nombre;
    private double precio;
    private double descuento;

    public Paquete(String nombre, double precio) {
        this.servicios = new ArrayList<>();
        this.nombre = nombre;
        this.precio = tarifaNoEsNegativa(precio);
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
    public final double tarifaNoEsNegativa(double precio) {
        if (precio < 0) {
            throw new TarifaNegativaException("El precio no puede ser negativo");
        }
        return precio;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void añadirServicio(Servicio servicio) {
        servicios.add(servicio);
    }

    public String getDescripcion() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}
