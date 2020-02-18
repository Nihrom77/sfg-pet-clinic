package com.springframework.cfgpetclinic.repositories;

import com.springframework.cfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
