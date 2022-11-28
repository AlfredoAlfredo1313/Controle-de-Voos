package com.mosz.ctrl_voos.aplicacao.dto;

import java.util.List;

import com.mosz.ctrl_voos.negocio.entidades.Aerovia;
import com.mosz.ctrl_voos.negocio.entidades.Rota;

public class RotasDTO {
    private int id;
    private List<String> aerovias;
    private double length;

    public RotasDTO(Rota rota)
    {
        id = rota.getId();
        aerovias = rota.getAerovias().stream().map(Aerovia::getId).toList();
        length = rota.getAerovias().stream().map(Aerovia::getDistancia).reduce((double) 0, (total, element) -> total + element);
    }

    public int getId() {
        return id;
    }

    public List<String> getAerovias() {
        return aerovias;
    }

    public double getLength() {
        return length;
    }

}
