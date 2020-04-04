package com.springframework.cfgpetclinic.repositories;

import com.springframework.cfgpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
