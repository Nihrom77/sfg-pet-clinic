package com.springframework.cfgpetclinic.repositories;

import com.springframework.cfgpetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Speciality, Long> {
}
