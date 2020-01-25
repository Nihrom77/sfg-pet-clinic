package com.springframework.cfgpetclinic.services.map;

import com.springframework.cfgpetclinic.model.Pet;
import com.springframework.cfgpetclinic.services.CRUDService;

import java.util.Set;

public class PetServiceMap extends AbsctractMapService<Pet, Long> implements CRUDService<Pet, Long> {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}