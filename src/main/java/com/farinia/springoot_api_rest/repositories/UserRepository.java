package com.farinia.springoot_api_rest.repositories;

import com.farinia.springoot_api_rest.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    public abstract ArrayList<User> findByPriority(int priority);
}
