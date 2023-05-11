package com.farinia.springoot_api_rest.services;

import com.farinia.springoot_api_rest.models.UsuarioModel;
import com.farinia.springoot_api_rest.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService implements InterfazUsuarioService{
    @Autowired
    UsuarioRepository connection;
    @Override
    public ArrayList<UsuarioModel> listar() {

        return (ArrayList<UsuarioModel>)connection.findAll();
    }

    @Override
    public UsuarioModel guardarUsuario(UsuarioModel usuario) {
        return (UsuarioModel)connection.save(usuario);
    }

    @Override
    public Boolean actualizarUsuario(UsuarioModel usuario) {
        boolean resp = false;
        if(connection.findById(usuario.getId()) != null){
            connection.save(usuario);
            resp = true;
        }
        return resp;
    }

    @Override
    public Optional<UsuarioModel> getUsuarioById(Long id) {
        Optional<UsuarioModel> resp = connection.findById(id);
        return resp;
    }

    @Override
    public ArrayList<UsuarioModel> getByPrioridad(int prioridad) {
        return connection.findByPrioridad(prioridad);
    }

    @Override
    public Boolean eliminarUsuario(Long id) {
        try{
            connection.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
