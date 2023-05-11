package com.farinia.springoot_api_rest.controllers;

import com.farinia.springoot_api_rest.models.UsuarioModel;
import com.farinia.springoot_api_rest.services.InterfazUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    InterfazUsuarioService connection;
    @GetMapping("/listar")
    public ArrayList<UsuarioModel> listar(){
        return connection.listar();
    }

    @GetMapping("/prioridad/{prioridad}")
    public ArrayList<UsuarioModel> listarByPrioridad(@PathVariable int prioridad){
        return connection.getByPrioridad(prioridad);
    }

    @GetMapping("/id/{id}")
    public Optional<UsuarioModel> listarById(@PathVariable Long id){
        return connection.getUsuarioById(id);
    }

    @PostMapping("/guardar")
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return connection.guardarUsuario(usuario);
    }

    @PostMapping("/actualizar")
    public String actualizarUsuario(@RequestBody UsuarioModel usuario){
        if(connection.actualizarUsuario(usuario)){
            return "Actualizacion exitosa";
        }
        return "Error en la actualizacion";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUsuario(@PathVariable Long id){
         if(connection.eliminarUsuario(id)){
             return "Se elimino de forma exitosa";
         }
        return "Hubo en la baja";
    }
}
