package com.farinia.springoot_api_rest.services;

import com.farinia.springoot_api_rest.models.User;
import com.farinia.springoot_api_rest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService implements InterfaceUserService {
    @Autowired
    UserRepository connection;
    @Override
    public ArrayList<User> list() {

        return (ArrayList<User>)connection.findAll();
    }

    @Override
    public User saveUser(User usuario) {
        return (User)connection.save(usuario);
    }

    @Override
    public Boolean updateUser(User usuario) {
        boolean resp = false;
        if(connection.findById(usuario.getId()) != null){
            connection.save(usuario);
            resp = true;
        }
        return resp;
    }

    @Override
    public Optional<User> getUserById(Long id) {
        Optional<User> resp = connection.findById(id);
        return resp;
    }

    @Override
    public ArrayList<User> getByPriority(int prioridad) {

        return connection.findByPriority(prioridad);
    }


    @Override
    public Boolean deleteUser(Long id) {
        try{
            connection.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
