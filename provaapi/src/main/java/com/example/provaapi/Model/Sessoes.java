package com.example.provaapi.Model;

public class Sessoes {
    private int id;
    private String nomeFilme;
    private String horario;
    private int numSala;

    public Sessoes(int id, String nomeFilme, String horario, int numSala) {
        this.id = id;
        this.nomeFilme = nomeFilme;
        this.horario = horario;
        this.numSala = numSala;
    }

    public Sessoes() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getNumSala() {
        return numSala;
    }

    public void setNumSala(int numSala) {
        this.numSala = numSala;
    }
}