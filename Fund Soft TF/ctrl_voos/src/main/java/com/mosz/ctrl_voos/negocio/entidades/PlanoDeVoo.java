package com.mosz.ctrl_voos.negocio.entidades;

public class PlanoDeVoo {
    private int id;
    private double velocidade;
    private String Horario;
    private String Mes;
    private int Dia;
    private String pontoDePartida;
    private String pontoDeChegada;
    private int Rota;
    private int Altura;

    public PlanoDeVoo(int id, double velocidade, String Horario, String Mes, int Dia, String pontoDePartida, String pontoDeChegada) {
        this.id = id;
        this.velocidade = velocidade;
        this.Horario = Horario;
        this.Mes = Mes;
        this.Dia = Dia;
        this.pontoDePartida = pontoDePartida;
        this.pontoDeChegada = pontoDeChegada;
    }

    public PlanoDeVoo(int id, double velocidade, String Horario, String Mes, int Dia, String pontoDePartida,
            String pontoDeChegada, int Rota) {
        this.id = id;
        this.velocidade = velocidade;
        this.Horario = Horario;
        this.Mes = Mes;
        this.Dia = Dia;
        this.pontoDePartida = pontoDePartida;
        this.pontoDeChegada = pontoDeChegada;
        this.Rota = Rota;
    }

    public int getId() {
        return id;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public String getHorario() {
        return Horario;
    }

    public String getMes() {
        return Mes;
    }

    public int getDia() {
        return Dia;
    }

    public String getPontoDePartida() {
        return pontoDePartida;
    }

    public String getPontoDeChegada() {
        return pontoDeChegada;
    }

    public int getRota() {
        return Rota;
    }

    public void setRota(int Rota) {
        this.Rota = Rota;
    }
}
