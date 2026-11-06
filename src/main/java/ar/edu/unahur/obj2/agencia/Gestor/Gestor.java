package ar.edu.unahur.obj2.agencia.Gestor;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

import ar.edu.unahur.obj2.agencia.Excepciones.NadaParaRevertirException;
import ar.edu.unahur.obj2.agencia.Modificaciones.Modificaciones;

public class Gestor {
    private final Deque<Modificaciones> historial = new ArrayDeque<>();
    private final Queue<Modificaciones> programadas = new ArrayDeque<>();

    public void ejecutar(Modificaciones modificacion) {
        modificacion.ejecutar();
        historial.push(modificacion);
    }

    public void deshacer() {
        if (historial.isEmpty()) {
            throw new NadaParaRevertirException("No hay modificaciones para revertir.");
        }
        historial.pop().deshacer();
    }

    public void programar(Modificaciones modificacion) {
        programadas.add(modificacion);
    }

    public void ejecutarProgramadas() {
        while (!programadas.isEmpty()) {
            ejecutar(programadas.peek());
            programadas.poll();
        }
    }

    public int cantidadDeModificacionesEjecutadas() { return historial.size(); }
    public int cantidadDeModificacionesProgramadas() { return programadas.size(); }
}