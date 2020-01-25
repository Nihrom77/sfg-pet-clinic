package com.springframework.cfgpetclinic.services;

import com.springframework.cfgpetclinic.model.Owner;

public interface OwnerService extends CRUDService<Owner, Long> {
    Owner findByLastName(String lastName);
}
