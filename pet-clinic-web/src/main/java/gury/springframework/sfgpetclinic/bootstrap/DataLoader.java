package gury.springframework.sfgpetclinic.bootstrap;

import gury.springframework.sfgpetclinic.model.*;
import gury.springframework.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

        private final OwnerService ownerService;
        private final VetService vetService;
        private final PetTypeService petTypeService;
        private final SpecialityService specialtyService;
        private final VisitService visitService;

        public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                          SpecialityService specialtyService, VisitService visitService) {
            this.ownerService = ownerService;
            this.vetService = vetService;
            this.petTypeService = petTypeService;
            this.specialtyService = specialtyService;
            this.visitService = visitService;
        }

        @Override
        public void run(String... args) throws Exception {

            int count = petTypeService.findAll().size();

            if (count == 0 ){
                loadData();
            }
        }

        private void loadData() {
            PetType dog = new PetType();
            dog.setName("Dog");
            PetType savedDogPetType = petTypeService.save(dog);

            PetType cat = new PetType();
            cat.setName("Cat");
            PetType savedCatPetType = petTypeService.save(cat);

            Speciality radiology = new Speciality();
            radiology.setDescription("Radiology");
            Speciality savedRadiology = specialtyService.save(radiology);

            Speciality surgery = new Speciality();
            surgery.setDescription("Surgery");
            Speciality savedSurgery = specialtyService.save(surgery);

            Speciality dentistry = new Speciality();
            dentistry.setDescription("dentistry");
            Speciality savedDentistry = specialtyService.save(dentistry);

            Owner owner1 = new Owner();
            owner1.setFirstname("Michael");
            owner1.setLastname("Weston");
            owner1.setAddress("123 Brickerel");
            owner1.setCity("Miami");
            owner1.setTelephone("1231231234");

            Pet mikesPet = new Pet();
            mikesPet.setPetType(savedDogPetType);
            mikesPet.setOwner(owner1);
            mikesPet.setBirthDate(LocalDate.now());
            mikesPet.setName("Rosco");
            owner1.getPets().add(mikesPet);

            ownerService.save(owner1);

            Owner owner2 = new Owner();
            owner2.setFirstname("Fiona");
            owner2.setLastname("Glenanne");
            owner2.setAddress("123 Brickerel");
            owner2.setCity("Miami");
            owner2.setTelephone("1231231234");

            Pet fionasCat = new Pet();
            fionasCat.setName("Just Cat");
            fionasCat.setOwner(owner2);
            fionasCat.setBirthDate(LocalDate.now());
            fionasCat.setPetType(savedCatPetType);
            owner2.getPets().add(fionasCat);

            ownerService.save(owner2);



            Visit catVisit = new Visit();
            catVisit.setPet(fionasCat);
            catVisit.setDate(LocalDate.now());
            catVisit.setDescription("Sneezy Kitty");

            visitService.save(catVisit);

            System.out.println("Loaded Owners....");

            Vet vet1 = new Vet();
            vet1.setFirstname("Sam");
            vet1.setLastname("Axe");
            vet1.getSpecialities().add(savedRadiology);

            vetService.save(vet1);

            Vet vet2 = new Vet();
            vet2.setFirstname("Jessie");
            vet2.setLastname("Porter");
            vet2.getSpecialities().add(savedSurgery);

            vetService.save(vet2);

            System.out.println("Loaded Vets....");
        }
    }


//    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
//                      SpecialityService specialitiesService, VisitService visitService) {
//        this.ownerService = ownerService;
//        this.vetService = vetService;
//        this.petTypeService = petTypeService;
//        this.specialitiesService = specialitiesService;
//        this.visitService = visitService;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        int count =petTypeService.findAll().size();
//
//        if(count==0){
//            loadData();
//        }
//    }
//
//    private void loadData() {
//        PetType dog=new PetType();
//        dog.setName("dog");
//        PetType savedDogPetType =petTypeService.save(dog);
//
//        PetType cat=new PetType();
//        cat.setName("cat");
//        PetType savedCatPetType =petTypeService.save(cat);
//
//        Speciality radiology =new Speciality();
//        radiology.setDescription("Radiology");
//        Speciality saveRadiology=specialitiesService.save(radiology);
//
//        Speciality surgery =new Speciality();
//        surgery.setDescription("Surgery");
//        Speciality saveSurgery=specialitiesService.save(surgery);
//
//        Speciality dentistry =new Speciality();
//        dentistry.setDescription("Dentistry");
//        Speciality saveDentistry=specialitiesService.save(dentistry);
//
//        Owner owner1=new Owner();
//        owner1.setFirstname("Fedor");
//        owner1.setLastname("Sherbanyuk");
//        owner1.setAddress("Maxaradze 7");
//        owner1.setCity("Donetsk");
//        owner1.setTelephone("11111112333");
//
//
//        Pet mikesPet= new Pet();
//        mikesPet.setPetType(savedDogPetType);
//        mikesPet.setOwner(owner1);
//        mikesPet.setBirthDate(LocalDate.now());
//        mikesPet.setName("Dick");
//        owner1.getPets().add(mikesPet);
//        ownerService.save(owner1);
//
//        Owner owner2=new Owner();
//        owner2.setFirstname("Vladimir");
//        owner2.setLastname("Sherbanyuk");
//        owner2.setAddress("Maxaradze 7");
//        owner2.setCity("Donetsk");
//        owner2.setTelephone("999999999999999");
//        System.out.println("Load Owners");
//
//        Pet sonuCat= new Pet();
//        mikesPet.setName("Sonu");
//        mikesPet.setOwner(owner2);
//        mikesPet.setBirthDate(LocalDate.now());
//        mikesPet.setPetType(savedCatPetType);
//
//
//
//
//        Visit catVisit=new Visit();
//        catVisit.setPet(sonuCat);
//        catVisit.setDate(LocalDate.now());
//        catVisit.setDescription("Sneezy Sonu");
//        visitService.save(catVisit);
//        owner2.getPets().add(sonuCat);
//        ownerService.save(owner2);
//        Vet vet1=new Vet();
//        vet1.setFirstname("F");
//        vet1.setLastname("S");
//        vet1.getSpecialities().add(saveRadiology);
//        vetService.save(vet1);
//
//        Vet vet2=new Vet();
//        vet2.setFirstname("V");
//        vet2.setLastname("S");
//        vet2.getSpecialities().add(saveSurgery);
//        vetService.save(vet2);
//        System.out.println("Load Vets");
//
//
//
//    }

