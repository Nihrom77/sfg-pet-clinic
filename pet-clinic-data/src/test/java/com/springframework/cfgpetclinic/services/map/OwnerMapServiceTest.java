package com.springframework.cfgpetclinic.services.map;

import com.springframework.cfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    private final long ownerId = 1L;

    private final String lastName = "Smith";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();
        assertEquals(ownerId, ownerSet.size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void saveExistingId() {
        long id = 2L;
        Owner owner2 = Owner.builder().id(id).build();
        Owner owner2Saved = ownerMapService.save(owner2);
        assertEquals(id, owner2Saved.getId());

    }

    @Test
    public void saveNoId() {
        Owner ow = ownerMapService.save(Owner.builder().build()); //No id
        assertNotNull(ow);
        assertNotNull(ow.getId());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);
        assertNotNull(owner);
        assertEquals(owner.getId(), ownerId);
    }

    @Test
    void findByLastNameExists() {
        Owner byLastName = ownerMapService.findByLastName(lastName);
        assertNotNull(byLastName);

    }

    @Test
    void findByLastNameNotExists() {

        Owner empty = ownerMapService.findByLastName("test");
        assertNull(empty);
    }
}
