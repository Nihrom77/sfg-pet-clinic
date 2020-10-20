package com.springframework.cfgpetclinic.services.springdatajpa;

import com.springframework.cfgpetclinic.model.Owner;
import com.springframework.cfgpetclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@Transactional
@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {


    @InjectMocks
    private OwnerSDJpaService ownerService;

    @Mock
    OwnerRepository ownerRepository;

    private Owner returnOwner;
    private final String name = "Smith";

    @BeforeEach
    void setUp() {
        //Чтобы каждый тест получил новый объект, на случай если будут модификации объекта.
        returnOwner = Owner.builder().id(1L).lastName(name).build();
    }

    @Test
    void findByLastName() {


        when(ownerService.findByLastName(any())).thenReturn(returnOwner); //Мок при обращении к БД

        Owner owner = ownerService.findByLastName(name);
        assertEquals(owner.getLastName(), name);
        verify(ownerRepository).findByLastName(any());//Проверим, что сервис обратился к БД
    }

    @Test
    void findAll() {
        Set<Owner> returnOwnerSet = new HashSet<>();
        returnOwnerSet.add(Owner.builder().id(1L).build());
        returnOwnerSet.add(Owner.builder().id(2L).build());
        when(ownerRepository.findAll()).thenReturn(returnOwnerSet);

        Set<Owner> owners = ownerService.findAll();
        assertNotNull(owners);
        assertEquals(2, owners.size());

    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner ow = ownerService.findById(1L);
        assertNotNull(ow);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner ow = ownerService.findById(1L);
        assertNull(ow);
    }

    @Test
    void save() {
        Owner owner = Owner.builder().lastName("asd").build();
        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner ow = ownerService.save(owner);
        assertNotNull(ow);
        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        ownerService.delete(returnOwner);
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        ownerService.deleteById(1L);
        verify(ownerRepository).deleteById(1L);
    }
}
