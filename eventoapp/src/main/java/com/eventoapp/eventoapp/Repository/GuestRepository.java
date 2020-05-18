package com.eventoapp.eventoapp.Repository;

import com.eventoapp.eventoapp.Models.Event;
import com.eventoapp.eventoapp.Models.Guest;
import org.springframework.data.repository.CrudRepository;

public interface GuestRepository extends CrudRepository<Guest, String> {
    Iterable<Guest> findByEvent(Event event);
}
