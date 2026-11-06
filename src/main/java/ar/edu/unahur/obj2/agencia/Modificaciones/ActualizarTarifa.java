package ar.edu.unahur.obj2.agencia.Modificaciones;

import ar.edu.unahur.obj2.agencia.Servicios.Servicio;

public class ActualizarTarifa implements Modificaciones {
    private double tarifaAnterior;
    private double tarifaNueva;
    private Servicio servicio;

    public ActualizarTarifa(Servicio servicio, double tarifaNueva) {
        this.servicio = servicio;
        this.tarifaAnterior = servicio.getTarifa();
        this.tarifaNueva = tarifaNueva;
    }

    @Override
    public void ejecutar() {
        servicio.setTarifa(tarifaNueva);
    }

    @Override
    public void deshacer() {
        servicio.setTarifa(tarifaAnterior);
    }
}
