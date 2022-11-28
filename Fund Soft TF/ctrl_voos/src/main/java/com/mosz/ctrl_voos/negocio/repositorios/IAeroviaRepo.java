package com.mosz.ctrl_voos.negocio.repositorios;

import java.util.List;

import com.mosz.ctrl_voos.aplicacao.dto.PlanoDTO;
import com.mosz.ctrl_voos.negocio.entidades.Aerovia;
import com.mosz.ctrl_voos.negocio.entidades.TimeSlot;

public interface IAeroviaRepo {
    public List<Aerovia> todos();
    public boolean cadastroAerovia(Aerovia aerovia);
    public boolean registraSlot(TimeSlot timeSlot, int idPlano, String idAerovia, int altura);
    public boolean removeAerovia(String id);
    public Aerovia findById(String id);
    public boolean cancelaSlot(String aeroviaId, String data, int slot);
    public boolean verificaPlano(PlanoDTO plano, Aerovia aerovia);
}