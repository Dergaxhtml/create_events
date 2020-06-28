package com.sda.party.repository;

import com.sda.party.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer>    {
        Role findByName(String name);
}
