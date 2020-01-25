package com.springframework.cfgpetclinic.services.map;

import com.springframework.cfgpetclinic.model.Owner;
import com.springframework.cfgpetclinic.services.CRUDService;
import com.springframework.cfgpetclinic.services.OwnerService;

import java.util.Set;

public class OwnerServiceMap extends AbsctractMapService<Owner, Long> implements CRUDService<Owner, Long> {

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {

        return super.save(object.getId(), object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }
}