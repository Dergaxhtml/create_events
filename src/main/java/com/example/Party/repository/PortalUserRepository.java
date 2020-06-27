package com.example.Party.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortalUserRepository extends JpaRepository<User,Integer> {
}
