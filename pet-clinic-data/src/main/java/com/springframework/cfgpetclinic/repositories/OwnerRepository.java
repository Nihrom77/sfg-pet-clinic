package com.springframework.cfgpetclinic.repositories;

import com.springframework.cfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * JPA создаст реализацию и напишет запросы автоматически.
 */
public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastName);
}
