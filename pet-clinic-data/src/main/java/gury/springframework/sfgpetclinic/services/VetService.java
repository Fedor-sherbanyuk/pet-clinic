package gury.springframework.sfgpetclinic.services;

import gury.springframework.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

   Vet findById(Long id);

   Vet save(Vet vet);

   Set<Vet> findAll();


}
