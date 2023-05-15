package com.farinia.springoot_api_rest.services;

import com.farinia.springoot_api_rest.models.User;

import java.util.ArrayList;

public interface InterfaceUserService {

    public ArrayList<User> list();

    public User saveUser(User user);
    public Boolean updateUser(User user);

    public User getUserById(Long id);
    public ArrayList<User> getByPriority(int priority);
    public Boolean deleteUser(Long id);
}
