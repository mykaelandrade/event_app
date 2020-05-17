package com.eventoapp.eventoapp.Repository;

import com.eventoapp.eventoapp.Models.Guest;
import org.springframework.data.repository.CrudRepository;

public interface GuestRepository extends CrudRepository<Guest, String> {
}
