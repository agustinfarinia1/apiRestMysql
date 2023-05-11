package com.farinia.springoot_api_rest.controllers;

import com.farinia.springoot_api_rest.models.User;
import com.farinia.springoot_api_rest.services.InterfaceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    InterfaceUserService connection;
    @GetMapping("/list")
    public ArrayList<User> list(){
        return connection.list();
    }

    @GetMapping("/priority/{priority}")
    public ArrayList<User> listarByPrioridad(@PathVariable int priority){
        return connection.getByPriority(priority);
    }

    @GetMapping("/id/{id}")
    public Optional<User> listarById(@PathVariable Long id){
        return connection.getUserById(id);
    }

    @PostMapping("/save")
    public User guardarUsuario(@RequestBody User usuario){
        return connection.saveUser(usuario);
    }

    @PostMapping("/update")
    public String actualizarUsuario(@RequestBody User usuario){
        if(connection.updateUser(usuario)){
            return "Actualizacion exitosa";
        }
        return "Error en la actualizacion";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUsuario(@PathVariable Long id){
         if(connection.deleteUser(id)){
             return "Se elimino de forma exitosa";
         }
        return "Hubo en la baja";
    }
}
