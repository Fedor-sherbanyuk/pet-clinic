package gury.springframework.sfgpetclinic.services;

import gury.springframework.sfgpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

   Pet findById(Long id);

   Pet save(Pet pet);

   Set<Pet> findAll();


}
