package com.springframework.cfgpetclinic.services.map;

import com.springframework.cfgpetclinic.model.Vet;
import com.springframework.cfgpetclinic.services.CRUDService;

import java.util.Set;

public class VetServiceMap extends AbsctractMapService<Vet, Long> implements CRUDService<Vet, Long> {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
