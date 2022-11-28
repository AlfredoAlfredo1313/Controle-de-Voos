package com.mosz.ctrl_voos.aplicacao.servicos;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mosz.ctrl_voos.aplicacao.dto.PlanoDTO;
import com.mosz.ctrl_voos.aplicacao.dto.RotasDTO;
import com.mosz.ctrl_voos.negocio.entidades.Rota;
import com.mosz.ctrl_voos.negocio.repositorios.IRotaRepo;

@Component
public class ServicoRotas {
    private IRotaRepo rotaRepo;

    @Autowired
    public ServicoRotas(IRotaRepo rotaRepo) 
    {
        this.rotaRepo = rotaRepo;
    }

    public List<RotasDTO> getRotasFromPoints(String partida, String chegada)
    {
        List<RotasDTO> rotas = rotaRepo.todo().stream().filter(rota -> rota.getPartida().equals(partida) && rota.getChegada().equals(chegada)).map(rota -> new RotasDTO(rota)).toList();
        return rotas;
    }

    public List<RotasDTO> getRotasFromPlano(PlanoDTO plano)
    {
        List<RotasDTO> rotas = rotaRepo.todo().stream().
        filter(rota -> rota.getPartida().equals(plano.getPontoDePartida()) && rota.getChegada().equals(plano.getPontoDeChegada())).
        filter(rota -> rotaRepo.verificaPlano(plano, rota)).map(rota -> new RotasDTO(rota)).toList();

        return rotas;
    }
}
