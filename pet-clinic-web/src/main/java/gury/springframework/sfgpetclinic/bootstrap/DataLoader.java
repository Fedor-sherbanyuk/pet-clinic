package gury.springframework.sfgpetclinic.bootstrap;

import gury.springframework.sfgpetclinic.model.*;
import gury.springframework.sfgpetclinic.services.OwnerService;
import gury.springframework.sfgpetclinic.services.PetTypeService;
import gury.springframework.sfgpetclinic.services.SpecialityService;
import gury.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialitiesService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialitiesService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialitiesService = specialitiesService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count =petTypeService.findAll().size();

        if(count==0){
            loadData();
        }


    }

    private void loadData() {
        PetType dog=new PetType();
        dog.setName("dog");
        PetType savedDogPetType =petTypeService.save(dog);

        PetType cat=new PetType();
        cat.setName("cat");
        PetType savedCatPetType =petTypeService.save(cat);

        Speciality radiology =new Speciality();
        radiology.setDescription("Radiology");
        Speciality saveRadiology=specialitiesService.save(radiology);

        Speciality surgery =new Speciality();
        surgery.setDescription("Surgery");
        Speciality saveSurgery=specialitiesService.save(surgery);

        Speciality dentistry =new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality saveDentistry=specialitiesService.save(dentistry);

        Owner owner1=new Owner();
        owner1.setFirstname("Fedor");
        owner1.setLastname("Sherbanyuk");
        owner1.setAddress("Maxaradze 7");
        owner1.setCity("Donetsk");
        owner1.setTelephone("11111112333");
        ownerService.save(owner1);

        Pet mikesPet= new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Dick");
        owner1.getPets().add(mikesPet);

        Owner owner2=new Owner();
        owner2.setFirstname("Vladimir");
        owner2.setLastname("Sherbanyuk");
        owner2.setAddress("Maxaradze 7");
        owner2.setCity("Donetsk");
        owner2.setTelephone("999999999999999");
        ownerService.save(owner2);
        System.out.println("Load Owners");

        Pet sonuCat= new Pet();
        mikesPet.setPetType(savedCatPetType);
        mikesPet.setOwner(owner2);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Sonu");
        owner2.getPets().add(sonuCat);

        Vet vet1=new Vet();
        vet1.setFirstname("F");
        vet1.setLastname("S");
        vet1.getSpecialities().add(saveRadiology);
        vetService.save(vet1);

        Vet vet2=new Vet();
        vet2.setFirstname("V");
        vet2.setLastname("S");
        vet2.getSpecialities().add(saveSurgery);
        vetService.save(vet2);
        System.out.println("Load Vets");
    }
}
