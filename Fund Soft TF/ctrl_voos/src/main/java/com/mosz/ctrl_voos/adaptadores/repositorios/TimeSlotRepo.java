package com.mosz.ctrl_voos.adaptadores.repositorios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mosz.ctrl_voos.adaptadores.repositorios.CRUD.ITimeSlotCRUD;
import com.mosz.ctrl_voos.negocio.entidades.TimeSlot;
import com.mosz.ctrl_voos.negocio.repositorios.ITimeSlotRepo;

@Component
public class TimeSlotRepo implements ITimeSlotRepo{
    @Autowired
    private ITimeSlotCRUD timeSlotCRUD;

    @Override
    public List<TimeSlot> todo() {
        return timeSlotCRUD.findAll();
    }
    
}
