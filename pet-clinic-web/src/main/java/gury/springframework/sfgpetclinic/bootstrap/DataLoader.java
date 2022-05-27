package gury.springframework.sfgpetclinic.bootstrap;

import gury.springframework.sfgpetclinic.model.Owner;
import gury.springframework.sfgpetclinic.model.Vet;
import gury.springframework.sfgpetclinic.services.OwnerService;
import gury.springframework.sfgpetclinic.services.VetService;
import gury.springframework.sfgpetclinic.services.map.OwnerServiceMap;
import gury.springframework.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;



    public DataLoader() {
        ownerService=new OwnerServiceMap();
        vetService=new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1=new Owner();
        owner1.setId(1l);
        owner1.setFirstname("Fedor");
        owner1.setLastname("Sherbanyuk");
        ownerService.save(owner1);


        Owner owner2=new Owner();
        owner2.setId(2l);
        owner2.setFirstname("Vladimir");
        owner2.setLastname("Sherbanyuk");
        ownerService.save(owner2);
        System.out.println("Load Owners");

        Vet vet1=new Vet();
        vet1.setId(1l);
        vet1.setFirstname("F");
        vet1.setLastname("S");
        vetService.save(vet1);


        Vet vet2=new Vet();
        vet2.setId(2l);
        vet2.setFirstname("V");
        vet2.setLastname("S");
        vetService.save(vet2);
        System.out.println("Load Vets");

    }
}
