package com.mosz.ctrl_voos.adaptadores.repositorios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mosz.ctrl_voos.adaptadores.repositorios.CRUD.IRotaCRUD;
import com.mosz.ctrl_voos.aplicacao.dto.PlanoDTO;
import com.mosz.ctrl_voos.negocio.entidades.Aerovia;
import com.mosz.ctrl_voos.negocio.entidades.Rota;
import com.mosz.ctrl_voos.negocio.repositorios.IAeroviaRepo;
import com.mosz.ctrl_voos.negocio.repositorios.IRotaRepo;

@Component
public class RotaRepo implements IRotaRepo{
    @Autowired
    private IRotaCRUD rotaCRUD;
    @Autowired
    private IAeroviaRepo aeroviaRepo;

    @Override
    public List<Aerovia> getRotaAerovias(int id) {
       return rotaCRUD.findById(id).getAerovias();
    }

    public Rota findById(int id)
    {
        return rotaCRUD.findById(id);
    }

    public List<Rota> todo()
    {
        return rotaCRUD.findAll();
    }

    public boolean removeRota(int id)
    {
        rotaCRUD.deleteById(id);
        return true;
    }

    @Override
    public boolean verificaPlano(PlanoDTO plano, Rota rota)
    {
        List<Aerovia> aerovias = getRotaAerovias(rota.getId());
        String data = plano.getData();
        int altura = plano.getAltura();
        for (Aerovia aerovia : aerovias) {
            boolean b = aeroviaRepo.verificaPlano(plano, aerovia);
            if(b == false) return false;
        }
        return true;
    }

    public String calculaHorario(String horario, double distancia, double velocidade)
    {
        
        return null;
    }
}
