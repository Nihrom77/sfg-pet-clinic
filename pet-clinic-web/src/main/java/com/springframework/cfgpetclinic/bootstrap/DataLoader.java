package com.springframework.cfgpetclinic.bootstrap;

import com.springframework.cfgpetclinic.model.Owner;
import com.springframework.cfgpetclinic.model.Pet;
import com.springframework.cfgpetclinic.model.PetType;
import com.springframework.cfgpetclinic.model.Speciality;
import com.springframework.cfgpetclinic.model.Vet;
import com.springframework.cfgpetclinic.services.OwnerService;
import com.springframework.cfgpetclinic.services.PetTypeService;
import com.springframework.cfgpetclinic.services.SpecialitiesService;
import com.springframework.cfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * bootstrap - распротраненное название пакета для того,
 * что происходит на старте приложения.
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialitiesService specialitiesService;

    @Autowired //Не обязательно ставить эту аннотацию. В конструкторах бинов она по умолчанию.
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialitiesService specialitiesService) {
//        this.ownerService = new OwnerServiceMap();
//        this.vetService = new VetServiceMap();
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialitiesService = specialitiesService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (petTypeService.findAll().size() == 0) {
            loadData();
        }


    }

    private void loadData() {
        System.out.println("Loading data from code.");
        PetType dog = new PetType();
        dog.setName("dog");
        petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        petTypeService.save(cat);


        Owner o1 = new Owner();
        o1.setFirstName("Nata");
        o1.setLastName("Traya");
        o1.setAddress("Miami, Palm st. 14");
        o1.setCity("Miami");
        o1.setTelephone("+79558884455");

        Pet o1Pet = new Pet();
        o1Pet.setPetType(dog);
        o1Pet.setBirthDate(LocalDate.now());
        o1Pet.setName("random woof");
        o1Pet.setOwner(o1);
        ownerService.save(o1);

        Owner o2 = new Owner();
        o2.setFirstName("Kostya");
        o2.setLastName("Strelov");
        o2.setAddress("Toronto, Kliff st. 12");
        o2.setCity("Toronto");
        o2.setTelephone("+7555445652");

        Pet o2Pet = new Pet();
        o2Pet.setPetType(cat);
        o2Pet.setBirthDate(LocalDate.now());
        o2Pet.setName("Pirojok");
        o2Pet.setOwner(o2);

        Pet o2Pet2 = new Pet();
        o2Pet2.setPetType(dog);
        o2Pet2.setBirthDate(LocalDate.now());
        o2Pet2.setName("Iriska");
        o2Pet2.setOwner(o2);
        ownerService.save(o2);

        Owner o3 = new Owner();
        o3.setFirstName("Katya");
        o3.setLastName(null);//Будет пустая строка в отображении.
        o3.setAddress("Kazahstan, Ola st. 11");
        o3.setCity("Kazahstan");
        o3.setTelephone("+9955522255");
        ownerService.save(o3);


        Speciality s1 = new Speciality();
        s1.setDescription("sergery");
        specialitiesService.save(s1);

        Speciality s2 = new Speciality();
        s2.setDescription("dentisty");
        specialitiesService.save(s2);

        Vet v1 = new Vet();
        v1.setFirstName("Jango");
        v1.setLastName("Free");
        v1.getSpecialities().add(s1);
        vetService.save(v1);

        Vet v2 = new Vet();
        v2.setFirstName("Vera");
        v2.setLastName("Oplyrw");
        v2.getSpecialities().add(s2);
        vetService.save(v2);
    }


}
