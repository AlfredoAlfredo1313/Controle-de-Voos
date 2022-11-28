package com.mosz.ctrl_voos.adaptadores.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mosz.ctrl_voos.adaptadores.repositorios.AeroviaRepo;
import com.mosz.ctrl_voos.aplicacao.dto.PlanoDTO;
import com.mosz.ctrl_voos.aplicacao.dto.RotasDTO;
import com.mosz.ctrl_voos.aplicacao.servicos.ServicoRotas;
import com.mosz.ctrl_voos.negocio.entidades.Aerovia;
import com.mosz.ctrl_voos.negocio.entidades.Rota;
import com.mosz.ctrl_voos.negocio.entidades.TimeSlot;
import com.mosz.ctrl_voos.negocio.repositorios.IAeroviaRepo;
import com.mosz.ctrl_voos.negocio.repositorios.IRotaRepo;
import com.mosz.ctrl_voos.negocio.repositorios.ITimeSlotRepo;

@RestController
@RequestMapping("/ctrlVoos")
public class Controller {
    private IAeroviaRepo aeroRepo;
    private ITimeSlotRepo slotRepo;
    private IRotaRepo rotaRepo;
    private ServicoRotas servicoRotas;

    @Autowired
    public Controller(IAeroviaRepo aeroRepo, ITimeSlotRepo slotRepo, IRotaRepo rotaRepo, ServicoRotas servicoRotas) 
    {
        this.aeroRepo = aeroRepo;
        this.slotRepo = slotRepo;
        this.rotaRepo = rotaRepo;
        this.servicoRotas = servicoRotas;
    }

    //SERVIÇOS
    @GetMapping("servicos/rotas")
    @CrossOrigin(origins = "*")
    public List<RotasDTO> getRotasDTOs(@RequestParam final String partida, @RequestParam final String chegada)
    {
        return servicoRotas.getRotasFromPoints(partida, chegada);
    }

    @GetMapping("servicos/rotas_para_plano")
    @CrossOrigin(origins = "*")
    public List<RotasDTO> getRotasDTOs(@RequestBody final PlanoDTO plano)
    {
        return servicoRotas.getRotasFromPlano(plano);
    }

    //Consulta Aerovias
    @GetMapping("/aerovias")
    @CrossOrigin(origins = "*")
    public List<Aerovia> getAeorivias() 
    {
        return aeroRepo.todos();
    }

    //Consulta TimeSlots
    @GetMapping("/timeslots")
    @CrossOrigin(origins = "*")
    public List<TimeSlot> getTimeSlots()
    {
        return slotRepo.todo();
    }

    //Consulta TimeSlots de Aerovia
    @GetMapping("/aerovias/timeslots")
    @CrossOrigin(origins = "*")
    public List<TimeSlot> getAeroviaSlots(@RequestParam final String id)
    {
        Aerovia aerovia = aeroRepo.findById(id);
        return aerovia.getSlot();
    }

    @GetMapping("/rotas/aerovia")
    @CrossOrigin(origins = "*")
    public List<Aerovia> getRotaAerovias(@RequestParam final int id)
    {
        return rotaRepo.getRotaAerovias(id);
    }

    @GetMapping("/rotas")
    @CrossOrigin(origins = "*")
    public List<Rota> getRota()
    {
        return rotaRepo.todo();
    }

    @PostMapping("/removeRota")
    @CrossOrigin(origins = "*")
    public boolean removeRota(@RequestParam final int id)
    {
        return rotaRepo.removeRota(id);
    }

    //Cadastra Aerovia
    @PostMapping("/aerovias")
    @CrossOrigin(origins = "*")
    public boolean cadastroAerovia(@RequestBody final Aerovia aerovia)
    {
        return aeroRepo.cadastroAerovia(aerovia);
    }

    //Remova Aerovia
    @PostMapping("/removeAero")
    @CrossOrigin(origins = "*")
    public boolean removeAerovia(@RequestParam final String id)
    {
        return aeroRepo.removeAerovia(id);
    }

    //Registra Slot
    @PostMapping("/aerovias/timeslots")
    @CrossOrigin(origins = "*")
    public boolean registraTimeslots(@RequestParam final String aeroviaId, @RequestParam final int altura, @RequestBody final TimeSlot timeSlot)
    {
        return aeroRepo.registraSlot(timeSlot, 5, aeroviaId, altura);
    }

    //Cancela Slot
    @PostMapping("/cancela")
    @CrossOrigin(origins = "*")
    public boolean cancelaPlano(@RequestParam final String aeroviaId, @RequestParam final String data, @RequestParam final int altura)
    {
        return aeroRepo.cancelaSlot(aeroviaId, data, altura);
    }
}
