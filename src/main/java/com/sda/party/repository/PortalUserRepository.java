package com.sda.party.repository;

import com.sda.party.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortalUserRepository extends JpaRepository<User,Integer> {
    User findByLogin(String s);
}
