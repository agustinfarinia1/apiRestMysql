package com.farinia.springoot_api_rest.services;

import com.farinia.springoot_api_rest.models.UsuarioModel;
import java.util.ArrayList;
import java.util.Optional;

public interface InterfazUsuarioService {

    public ArrayList<UsuarioModel> listar();

    public UsuarioModel guardarUsuario(UsuarioModel usuario);
    public Boolean actualizarUsuario(UsuarioModel usuario);

    public Optional<UsuarioModel> getUsuarioById(Long id);
    public ArrayList<UsuarioModel> getByPrioridad(int prioridad);
    public Boolean eliminarUsuario(Long id);
}
