package gury.springframework.sfgpetclinic.bootstrap;

import gury.springframework.sfgpetclinic.model.Owner;
import gury.springframework.sfgpetclinic.model.PetType;
import gury.springframework.sfgpetclinic.model.Vet;
import gury.springframework.sfgpetclinic.services.OwnerService;
import gury.springframework.sfgpetclinic.services.PetTypeService;
import gury.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    private final PetTypeService petTypeService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog=new PetType();
        dog.setName("Dick");
        PetType savedDogPetType =petTypeService.save(dog);

        PetType cat=new PetType();
        cat.setName("Sonu");
        PetType savedCatPetType =petTypeService.save(cat);



        Owner owner1=new Owner();
        owner1.setFirstname("Fedor");
        owner1.setLastname("Sherbanyuk");
        ownerService.save(owner1);


        Owner owner2=new Owner();
        owner2.setFirstname("Vladimir");
        owner2.setLastname("Sherbanyuk");
        ownerService.save(owner2);
        System.out.println("Load Owners");

        Vet vet1=new Vet();
        vet1.setFirstname("F");
        vet1.setLastname("S");
        vetService.save(vet1);


        Vet vet2=new Vet();
        vet2.setFirstname("V");
        vet2.setLastname("S");
        vetService.save(vet2);
        System.out.println("Load Vets");

    }
}
