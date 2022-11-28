package com.mosz.ctrl_voos.negocio.repositorios;

import java.util.List;

import com.mosz.ctrl_voos.negocio.entidades.PlanoDeVoo;

public interface IPlanoVooRepo {    
    public List<PlanoDeVoo> todos();
    public boolean cadastraPlano(PlanoDeVoo planoDeVoo);
    public boolean cancelaPlano(int id);

}
