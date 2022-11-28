package com.mosz.ctrl_voos.aplicacao.dto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlanoDTO {
    private int ID;
    private double velocidade;
    private String data;
    private String pontoDePartida;
    private String pontoDeChegada;
    private int altura;

    public PlanoDTO(double velocidade, String Horario, String Mes, int Dia, String pontoDePartida, String pontoDeChegada, int altura, int ID) throws Exception {
        Pattern pat = Pattern.compile("^[0-2]\\d:[0-5]\\d$");
        Matcher matcher = pat.matcher(Horario);
        if(!matcher.find()) throw new Exception();
        switch(altura)
        {
            case 25000:
            case 26000:
            case 27000:
            case 28000:
            case 29000:
            case 30000:
            case 31000:
            case 32000:
            case 30003:
            case 34000:
            case 35000:
                this.altura = (altura - 25000)/1000;
                break;
            
            default: throw new Exception();
        }
        this.velocidade = velocidade;
        this.pontoDePartida = pontoDePartida;
        this.pontoDeChegada = pontoDeChegada;
        this.data = Dia + Mes + Horario;
        this.ID = ID;
    }

    public String getData() {
        return data;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public String getPontoDePartida() {
        return pontoDePartida;
    }

    public String getPontoDeChegada() {
        return pontoDeChegada;
    }

    public int getAltura() {
        return altura;
    }

    public int getID() {
        return ID;
    }

}
