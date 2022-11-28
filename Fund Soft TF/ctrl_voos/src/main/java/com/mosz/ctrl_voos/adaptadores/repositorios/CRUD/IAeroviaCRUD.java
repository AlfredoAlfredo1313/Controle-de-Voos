package com.mosz.ctrl_voos.adaptadores.repositorios.CRUD;

import org.springframework.data.repository.CrudRepository;

import com.mosz.ctrl_voos.negocio.entidades.Aerovia;

import java.util.List;

public interface IAeroviaCRUD extends CrudRepository<Aerovia, String>{
    List<Aerovia> findAll();
    Aerovia findAeroviaById(String id);
}
