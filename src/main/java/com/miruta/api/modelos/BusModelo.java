package com.miruta.api.modelos;

public class BusModelo {

    //Atributos
    private String placaBus;
    private Double longitudBus;
    private Double latitudBus;
    private Long identificacionCon;



    //Constructores
    public BusModelo() {
    }

    public BusModelo(String placaBus, Double longitudBus, Double latitudBus, Long identificacionCon) {
        this.placaBus = placaBus;
        this.longitudBus = longitudBus;
        this.latitudBus = latitudBus;
        this.identificacionCon = identificacionCon;
    }



    //Getters
    public String getPlacaBus() {
        return placaBus;
    }

    public Double getLongitudBus() {
        return longitudBus;
    }

    public Double getLatitudBus() {
        return latitudBus;
    }

    public Long getIdentificacionCon() {
        return identificacionCon;
    }



    //Setters
    public void setPlacaBus(String placaBus) {
        this.placaBus = placaBus;
    }

    public void setLongitudBus(Double longitudBus) {
        this.longitudBus = longitudBus;
    }

    public void setLatitudBus(Double latitudBus) {
        this.latitudBus = latitudBus;
    }

    public void setIdentificacionCon(Long identificacionCon) {
        this.identificacionCon = identificacionCon;
    }



}
