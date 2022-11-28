package com.mosz.ctrl_voos.adaptadores.repositorios.CRUD;

import org.springframework.data.repository.CrudRepository;

import com.mosz.ctrl_voos.negocio.entidades.TimeSlot;

import java.util.List;

public interface ITimeSlotCRUD extends CrudRepository<TimeSlot, String>{
    List<TimeSlot> findAll();
    TimeSlot findSlotById(String id);
}
