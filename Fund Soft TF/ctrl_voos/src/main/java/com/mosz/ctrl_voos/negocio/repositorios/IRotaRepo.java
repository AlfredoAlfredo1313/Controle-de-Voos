package com.mosz.ctrl_voos.negocio.repositorios;

import java.util.List;

import com.mosz.ctrl_voos.aplicacao.dto.PlanoDTO;
import com.mosz.ctrl_voos.negocio.entidades.Aerovia;
import com.mosz.ctrl_voos.negocio.entidades.Rota;


public interface IRotaRepo {
    List<Aerovia> getRotaAerovias(int id);
    public Rota findById(int id);
    public List<Rota> todo();
    public boolean removeRota(int id);
    public boolean verificaPlano(PlanoDTO plano, Rota rota);
}
