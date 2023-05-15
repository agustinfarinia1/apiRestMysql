package com.farinia.springoot_api_rest.controllers;

import com.farinia.springoot_api_rest.models.User;
import com.farinia.springoot_api_rest.services.InterfaceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    InterfaceUserService connection;
    @GetMapping("/list")
    public ArrayList<User> list(){
        return connection.list();
    }

    @GetMapping("/priority/{priority}")
    public ArrayList<User> listByPriority(@PathVariable int priority){
        return connection.getByPriority(priority);
    }

    @GetMapping("/id/{id}")
    public User listById(@PathVariable Long id){
        return connection.getUserById(id);
    }

    @PostMapping("/save")
    public User saveUser(@RequestBody User user){
        return connection.saveUser(user);
    }

    @PostMapping("/update")
    public String updateUser(@RequestBody User user){
        if(connection.updateUser(user)){
            return "Actualizacion exitosa";
        }
        return "Error en la actualizacion";
    }

    @PostMapping("/delete/{id}")
    public String deleteUsuario(@PathVariable Long id){
        if(connection.deleteUser(id)){
            return "Se elimino de forma exitosa";
        }
        return "Error en la baja";
    }
}
