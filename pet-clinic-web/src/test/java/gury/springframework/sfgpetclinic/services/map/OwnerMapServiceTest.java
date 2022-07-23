package gury.springframework.sfgpetclinic.services.map;

import gury.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {
    OwnerMapService ownerMapService;
    final Long aLong=1L;
    final String lastName ="Smith";

    @BeforeEach
    void setUp() {
        ownerMapService=new OwnerMapService(new PetTypeMapService(),new PetMapService());
        ownerMapService.save(Owner.builder().id(1L).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet=ownerMapService.findAll();
        assertEquals(1,ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner=ownerMapService.findById(aLong);
        assertEquals(1,owner.getId());
    }

    @Test
    void saveExistId() {
        long id = 2L;
        Owner owner2=Owner.builder().id(id).build();
        Owner ownerSave= ownerMapService.save(owner2);
        assertEquals(id,ownerSave.getId());
    }

    @Test
    void saveNoId() {

        Owner ownerSave= ownerMapService.save(Owner.builder().build());
        System.out.println(ownerSave.toString());
        assertNotNull(ownerSave);
        assertNotNull(ownerSave.getId());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(aLong));
        assertEquals(0,ownerMapService.findAll().size());
    }

    @Test
    void deleteId() {
        ownerMapService.deleteByID(aLong);
        assertEquals(0,ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner smith=ownerMapService.findByLastName(lastName);
        assertNotNull(smith);
        assertEquals(aLong,smith.getId());
    }
    @Test
    void findByLastNameNotFound() {
        Owner smith=ownerMapService.findByLastName("foo");
        assertNull(smith);
    }
}