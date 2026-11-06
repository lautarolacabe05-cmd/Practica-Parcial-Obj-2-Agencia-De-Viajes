package ar.edu.unahur.obj2.agencia.Catalogo;

import ar.edu.unahur.obj2.agencia.Paquetes.Paquete;
import ar.edu.unahur.obj2.agencia.Servicios.Servicio;

public class Catalogo {
    private final Servicio vueloBuenosAiresBariloche =  new Servicio("Vuelo Buenos Aires - Bariloche", 120000);
    private final Servicio hotelLlaoLlao = new Servicio("Hotel Llao Llao", 200000);
    private final Servicio excursionCerroCatedral = new Servicio("Excursion Cerro Catedral", 35000);
    private final Servicio hotelLosGlaciares = new Servicio("Hotel Los Glaciares", 150000);
    private final Servicio excursionPeritoMoreno = new Servicio("Excursion Perito Moreno", 60000);
    private final Servicio vueloBarilocheElCalafate = new Servicio("Vuelo Bariloche - El Calafate", 95000);
    private final Servicio vueloElCalafateBuenosAires = new Servicio("Vuelo El Calafate - Buenos Aires", 110000);

    private final Paquete barilocheClasico = new Paquete("Paquete Bariloche", 10, vueloBuenosAiresBariloche, hotelLlaoLlao, excursionCerroCatedral);
    private final Paquete calafateGlaciares = new Paquete("Paquete Calafate", 5, hotelLosGlaciares, excursionPeritoMoreno);
    private final Paquete aventuraPatagonica = new Paquete("Aventura Patagonica", 20, barilocheClasico, vueloBarilocheElCalafate, calafateGlaciares, vueloElCalafateBuenosAires);

    public Servicio getVueloBuenosAiresBariloche() {
        return vueloBuenosAiresBariloche;
    }
    public Servicio getHotelLlaoLlao() {
        return hotelLlaoLlao;
    }
    public Servicio getExcursionCerroCatedral() {
        return excursionCerroCatedral;
    }
    public Servicio getHotelLosGlaciares() {
        return hotelLosGlaciares;
    }
    public Servicio getExcursionPeritoMoreno() {
        return excursionPeritoMoreno;
    }
    public Servicio getVueloBarilocheElCalafate() {
        return vueloBarilocheElCalafate;
    }
    public Servicio getVueloElCalafateBuenosAires() {
        return vueloElCalafateBuenosAires;
    }
    public Paquete getBarilocheClasico() {
        return barilocheClasico;
    }
    public Paquete getCalafateGlaciares() {
        return calafateGlaciares;
    }
    public Paquete getAventuraPatagonica() {
        return aventuraPatagonica;
    }
}
