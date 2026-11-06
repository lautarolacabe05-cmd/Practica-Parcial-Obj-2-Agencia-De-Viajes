package ar.edu.unahur.obj2.agencia.Paquetes;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.agencia.Excepciones.DescuentoInvalidoException;
import ar.edu.unahur.obj2.agencia.Excepciones.TarifaNegativaException;
import ar.edu.unahur.obj2.agencia.Servicios.Servicio;

public abstract class Paquete {
    private final List<Servicio> servicios;
    private String nombre;
    private double descuento;

    public Paquete(String nombre, double descuento) {
        this.servicios = new ArrayList<>();
        this.nombre = nombre;
        this.descuento = descuentoEsValido(descuento);
    }
    public double getPrecio() {
        double precioTotal = 0;
        for (Servicio servicio : servicios) {
            precioTotal += servicio.getTarifa();
        }
        return precioTotal * (1 - descuento / 100);
    }
    public int cantidadDeServicios() {
        return servicios.size();
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
    public boolean tieneServicio(String nombre) {
        for (Servicio servicio : servicios) {
            if (servicio.tieneServicio(nombre)) {
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

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void añadirServicio(Servicio servicio) {
        servicios.add(servicio);
    }

    public String getDescripcion() {
        return nombre;
    }
}
