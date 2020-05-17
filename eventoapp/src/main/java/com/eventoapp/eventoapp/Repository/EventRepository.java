package com.eventoapp.eventoapp.Repository;

import com.eventoapp.eventoapp.Models.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, String> {
    Event findByCode(long code);
}
