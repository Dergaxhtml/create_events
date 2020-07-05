package com.sda.party.repository;

import com.sda.party.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByLogin(String login);
    List<User> findAll();
}
