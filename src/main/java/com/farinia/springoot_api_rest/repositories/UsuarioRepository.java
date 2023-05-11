package com.farinia.springoot_api_rest.repositories;

import com.farinia.springoot_api_rest.models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel,Long> {
    public abstract ArrayList<UsuarioModel> findByPrioridad(int prioridad);
}
