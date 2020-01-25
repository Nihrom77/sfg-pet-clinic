package com.springframework.cfgpetclinic.services;

import com.springframework.cfgpetclinic.model.Owner;

import java.util.Set;

public interface VetService {

    Owner findByLastName(String lastName);
    Owner findById(Long id);
    Owner save(Owner owner);
    Set<Owner> findAll();
}
