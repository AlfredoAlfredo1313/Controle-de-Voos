package com.mosz.ctrl_voos.negocio.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import java.util.List;

@Entity
public class Aerovia {
    @Id
    private String id;
    private String pontoDePartida;
    private String pontoDeChegada;
    private double distancia;

    @OneToMany(mappedBy = "aerovia", 
                cascade = CascadeType.ALL)
    private List<TimeSlot> timeSlots;

    @ManyToMany(mappedBy = "aerovias",
                cascade = CascadeType.ALL)
    private List<Rota> rotas; 

    public Aerovia(String id, String pontoDePartida, String pontoDeChegada, double distancia)
    {
        this.distancia = distancia;
        this.id = id;
        this.pontoDeChegada = pontoDeChegada;
        this.pontoDePartida = pontoDePartida;
    }

    public Aerovia() {
    }

    public String getPontoDePartida() {
        return pontoDePartida;
    }

    public String getPontoDeChegada() {
        return pontoDeChegada;
    }

    public double getDistancia() {
        return distancia;
    }

    public String getId() {
        return id;
    }

    public List<TimeSlot> getSlot() {
        return timeSlots;
    }

}
