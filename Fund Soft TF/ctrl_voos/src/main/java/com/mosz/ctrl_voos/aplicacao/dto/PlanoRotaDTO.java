package com.mosz.ctrl_voos.aplicacao.dto;

public class PlanoRotaDTO {
    private double velocidade;
    private String Horario;
    private String Mes;
    private int Dia;
    private String pontoDePartida;
    private String pontoDeChegada;
    private RotasDTO Rota;
    private int RotaID;
    private int altura;
    
    public PlanoRotaDTO(double velocidade, String Horario, String Mes, int Dia, String pontoDePartida, String pontoDeChegada, RotasDTO Rota, int altura) {
        this.velocidade = velocidade;
        this.Horario = Horario;
        this.Mes = Mes;
        this.Dia = Dia;
        this.pontoDePartida = pontoDePartida;
        this.pontoDeChegada = pontoDeChegada;
        this.altura = altura;
        this.Rota = Rota;
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

    public RotasDTO getRota() {
        return Rota;
    }

    public int getRotaID() {
        return RotaID;
    }

    public int getAltura() {
        return altura;
    }

    
}
