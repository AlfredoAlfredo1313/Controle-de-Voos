package com.mosz.ctrl_voos.adaptadores.repositorios.CRUD;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mosz.ctrl_voos.negocio.entidades.Rota;

public interface IRotaCRUD extends CrudRepository<Rota, Integer>{
    Rota findById(int id);
    List<Rota> findAll();
}
