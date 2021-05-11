package com.example.provaapi.Model;

public class Cinema {
    private int id;
    private  String nomeCinema ;
    private String localCinema ;
    private float valorCinema ;

    public Cinema(int id, String nomeCinema, String localCinema, float valorCinema) {
        this.id = id;
        this.nomeCinema = nomeCinema;
        this.localCinema = localCinema;
        this.valorCinema = valorCinema;
    }

    public Cinema() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCinema() {
        return nomeCinema;
    }

    public void setNomeCinema(String nomeCinema) {
        this.nomeCinema = nomeCinema;
    }

    public String getLocalCinema() {
        return localCinema;
    }

    public void setLocalCinema(String localCinema) {
        this.localCinema = localCinema;
    }

    public float getValorCinema() {
        return valorCinema;
    }

    public void setValorCinema(float valorCinema) {
        this.valorCinema = valorCinema;
    }
}