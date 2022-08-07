package gury.springframework.sfgpetclinic.services.springdatajpa;

import gury.springframework.sfgpetclinic.model.Owner;
import gury.springframework.sfgpetclinic.repositories.OwnerRepository;
import gury.springframework.sfgpetclinic.repositories.PetRepository;
import gury.springframework.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJPAServiceTest {

    public static final String SMITH = "Smith";
    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJPAService service;

    Owner returnOwner;


    @BeforeEach
    void setUp() {
        returnOwner=Owner.builder().id(1L).lastName(SMITH).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
        Owner smith=service.findByLastName(SMITH);
        assertEquals(SMITH,smith.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet=new HashSet<>();
        ownerSet.add(Owner.builder().id(1L).build());
        ownerSet.add(Owner.builder().id(2L).build());
        when(ownerRepository.findAll()).thenReturn(ownerSet);
        Set<Owner> owners=service.findAll();
        assertNotNull(owners);
        assertEquals(2,owners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
        Owner owner=service.findById(1L);
        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner owner=service.findById(1L);
        assertNull(owner);
    }

    @Test
    void save() {
        Owner ownerSet=Owner.builder().id(1L).build();
        when(ownerRepository.save(any())).thenReturn(returnOwner);
        Owner saveOwner=service.save(ownerSet);
        assertNotNull(saveOwner);

        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        service.delete(returnOwner);
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteByID() {
        service.deleteByID(1L);
        verify(ownerRepository).deleteById(anyLong());
    }
}