package com.springframework.cfgpetclinic.repositories;

import com.springframework.cfgpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
