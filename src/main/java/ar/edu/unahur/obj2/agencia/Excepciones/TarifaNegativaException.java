package ar.edu.unahur.obj2.agencia.Excepciones;

public class TarifaNegativaException extends RuntimeException {
    public TarifaNegativaException(String mensaje) {
        super(mensaje);
    }
    
}
