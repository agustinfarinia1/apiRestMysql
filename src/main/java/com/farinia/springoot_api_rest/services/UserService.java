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
    public ArrayList<User> list(){
        ArrayList<User> list = (ArrayList<User>) connection.findAll();
        return list;
    }

    @Override
    public User getUserById(Long id){
        Optional<User> resp = connection.findById(id);
        if(resp.isPresent()){
            return resp.get();
        }
        return null;
    }

    @Override
    public User saveUser(User user){
        user.setStatus(true);
        user =  connection.save(user);
        return user;
    }

    @Override
    public Boolean updateUser(User user){
        boolean resp = false;
        Optional<User> data = connection.findById(user.getId());
        if (data.isPresent()) {
            connection.save(user);
            resp = true;
        }
        return resp;
    }

    @Override
    public ArrayList<User> getByPriority(int prioridad) {
        return connection.findByPriority(prioridad);
    }


    @Override
    public Boolean deleteUser(Long id) {
        Optional<User> resp = connection.findById(id);
        if(resp.isPresent()){
            User user = resp.get();
            user.setStatus(false);
            connection.save(user);
            return true;
        }
        return false;
    }
}
