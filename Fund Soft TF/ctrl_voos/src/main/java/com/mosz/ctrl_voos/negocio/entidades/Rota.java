package com.mosz.ctrl_voos.negocio.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Rota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Partida;
    private String Chegada;
    @ManyToMany
    @JoinTable(
        name = "RotaAerovia",
        joinColumns = @JoinColumn(name = "rota_id"),
        inverseJoinColumns = @JoinColumn(name = "aerovia_id")
    )
    private List<Aerovia> aerovias;


    public Rota() {}

    public Rota(int id, String partida, String chegada) {
        this.id = id;
        Partida = partida;
        Chegada = chegada;
    }

    public int getId() {
        return id;
    }
    public String getPartida() {
        return Partida;
    }
    public String getChegada() {
        return Chegada;
    }
    public List<Aerovia> getAerovias() {
        return aerovias;
    }

    
}
