package com.sda.party.repository;

import com.sda.party.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository  extends JpaRepository<Event,Long> {
    Event getById(int id);
}
