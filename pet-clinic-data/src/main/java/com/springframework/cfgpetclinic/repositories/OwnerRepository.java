package com.springframework.cfgpetclinic.repositories;

import com.springframework.cfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

/**
 * JPA создаст реализацию и напишет запросы автоматически.
 */
public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastName);
}
