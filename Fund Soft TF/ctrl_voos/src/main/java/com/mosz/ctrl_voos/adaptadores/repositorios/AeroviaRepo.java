package com.mosz.ctrl_voos.adaptadores.repositorios;

import java.util.List;
import java.util.Optional;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mosz.ctrl_voos.adaptadores.repositorios.CRUD.IAeroviaCRUD;
import com.mosz.ctrl_voos.adaptadores.repositorios.CRUD.ITimeSlotCRUD;
import com.mosz.ctrl_voos.aplicacao.dto.PlanoDTO;
import com.mosz.ctrl_voos.negocio.entidades.Aerovia;
import com.mosz.ctrl_voos.negocio.entidades.TimeSlot;
import com.mosz.ctrl_voos.negocio.repositorios.IAeroviaRepo;

@Component
public class AeroviaRepo implements IAeroviaRepo{
    private IAeroviaCRUD AeroviaCRUD;
    private ITimeSlotCRUD timeSlotCRUD;

    @Autowired
    public AeroviaRepo(IAeroviaCRUD AeroviaCRUD, ITimeSlotCRUD timeSlotCRUD) {
        this.AeroviaCRUD = AeroviaCRUD;
        this.timeSlotCRUD = timeSlotCRUD;
    }

    @Override
    public List<Aerovia> todos() {
        return AeroviaCRUD.findAll();
    }

    @Override
    public boolean cadastroAerovia(Aerovia aerovia) {
        AeroviaCRUD.save(aerovia);
        return true;
    }

    @Override
    public boolean removeAerovia(String id) {
        Aerovia aerovia = AeroviaCRUD.findAeroviaById(id);
        AeroviaCRUD.delete(aerovia);
        return true;
    }

    @Transactional
    public boolean registraSlot(PlanoDTO planoDTO, String idAerovia, int altura) {
        int planoId = planoDTO.getID();
        String data = planoDTO.getData();
        Aerovia aerovia = AeroviaCRUD.findAeroviaById(idAerovia);
        String slot = buildSlot(data, aerovia, altura, planoId);
        TimeSlot timeSlot = new TimeSlot(data, slot);
        Optional<TimeSlot> optional = aerovia.getSlot().stream().filter(s -> s.getData().equals(timeSlot.getData())).findAny();
        if(optional.isEmpty())
        {
            timeSlot.setAerovia(aerovia);
            timeSlotCRUD.save(timeSlot); 
        }
        TimeSlot originalSlot = optional.get();
        String slot = buildSlot(timeSlot, originalSlot, idPlano, altura);
        if(slot == null) return false;
        originalSlot.setTimeSlots(slot);
        return true;
    }

    public String buildSlot(TimeSlot timeSlot, TimeSlot originalSlot, int idPlano, int altura)
    {
        String heightSlot = originalSlot.getTimeSlots();
        String array[] = heightSlot.split(",");
        if(!array[altura].equals("0")) return null;
        array[altura] = String.valueOf(idPlano); 
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(i <9 ? array[i] + "," : array[i]);
        }
        return sb.toString();
    }

    public String buildSlot(String data, Aerovia aerovia, int altura, int idPlano)
    {
        Optional<TimeSlot> optional = aerovia.getSlot().stream().filter(s -> s.getData().equals(data)).findAny();
        if(optional.isEmpty()) return "";
        String heightSlot = optional.get().getTimeSlots();
        String array[] = heightSlot.split(",");
        if(!array[altura].equals("0")) return null;
        array[altura] = String.valueOf(idPlano); 
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(i <9 ? array[i] + "," : array[i]);
        }
        return sb.toString();
    }

    @Override
    public boolean verificaPlano(PlanoDTO plano, Aerovia aerovia)
    {
        String data = plano.getData();
        String hora = data.substring(0, 6);
        int altura = plano.getAltura();
        boolean bool = true;
        double distancia = aerovia.getDistancia();
        double velocidade = plano.getVelocidade();
        double tempoRestante = 1;
        double minutos = Double.parseDouble(data.substring(data.length() - 2, data.length()));
        minutos /= 60;
        while(tempoRestante > 0)
        {
            tempoRestante = distancia/velocidade;
            bool = verificaSlot(hora, aerovia, altura);
            if(bool == false) return false;
            tempoRestante -= minutos;
            distancia -= velocidade;
            hora = avancaHora(hora);
            
        }
        return true;
    }

    public boolean verificaSlot(String data, Aerovia aerovia, int altura)
    {
        Optional<TimeSlot> optional = aerovia.getSlot().stream().filter(s -> s.getData().equals(data)).findAny();
        if(optional.isEmpty()) return true;
        String heightSlot = optional.get().getTimeSlots();
        String array[] = heightSlot.split(",");
        if(!array[altura].equals("0")) return false;
        return true;
    }

    public String avancaHora(String data)
    {
        boolean changeDia = false;
        int hora = Integer.parseInt(data.substring(4, 6));
        hora++;
        if(hora > 23)
        {
            hora = hora % 24;
            changeDia = true;
        }
        String newHora = hora > 9?  String.valueOf(hora): "0" + String.valueOf(hora);
        data = data.substring(0, 4) + newHora;
        if(hora > 23)
        {
            int dia = Integer.parseInt(data.substring(0, 2));
            dia++;
            String newDia = dia > 9? String.valueOf(dia) : "0" + String.valueOf(dia);
            data = newDia + data.substring(2);
        } 
        return data;
    }

    @Override
    @Transactional
    public boolean cancelaSlot(String aeroviaId, String data, int slot)
    {
        List<TimeSlot> timeSlots = AeroviaCRUD.findAeroviaById(aeroviaId).getSlot();
        Optional<TimeSlot> optional = timeSlots.stream().filter(x -> x.getData().equals(data)).findFirst();
        TimeSlot t = optional.get();
        String array[] = t.getTimeSlots().split(",");
        array[slot] = "0";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(i <9 ? array[i] + "," : array[i]);
        }
        t.setTimeSlots(sb.toString());
        return false;
    }

    @Override
    public Aerovia findById(String id) {
        return AeroviaCRUD.findAeroviaById(id);
    }

    public String calculaHorario(String horario, double distancia, double velocidade)
    {
        return null;
    }
}
