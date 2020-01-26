package com.springframework.cfgpetclinic.bootstrap;

import com.springframework.cfgpetclinic.model.Owner;
import com.springframework.cfgpetclinic.model.Vet;
import com.springframework.cfgpetclinic.services.OwnerService;
import com.springframework.cfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * bootstrap - распротраненное название пакета для того,
 * что происходит на старте приложения.
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    @Autowired //Не обязательно ставить эту аннотацию. В конструкторах бинов она по умолчанию.
    public DataLoader(OwnerService ownerService, VetService vetService) {
//        this.ownerService = new OwnerServiceMap();
//        this.vetService = new VetServiceMap();
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner o1 = new Owner();
        o1.setFirstName("Nata");
        o1.setLastName("Traya");
        o1.setId(1L);
        ownerService.save(o1);

        Owner o2 = new Owner();
        o2.setFirstName("Kostya");
        o2.setLastName("Strelov");
        o2.setId(2L);

        Owner o3 = new Owner();
        o3.setFirstName("Kostya");
        o3.setLastName(null);
        o3.setId(3L);
        ownerService.save(o3);


        Vet v1 = new Vet();
        v1.setFirstName("Jango");
        v1.setLastName("Free");
        v1.setId(1L);
        vetService.save(v1);

        Vet v2 = new Vet();
        v2.setFirstName("Vera");
        v2.setLastName("Oplyrw");
        v2.setId(2L);
        vetService.save(v2);
    }
}
