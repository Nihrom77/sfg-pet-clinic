package com.springframework.cfgpetclinic.repositories;

import com.springframework.cfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
