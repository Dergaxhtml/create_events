package com.sda.party.repository;

import com.sda.party.model.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository  extends CrudRepository<Event,Long> {
}
