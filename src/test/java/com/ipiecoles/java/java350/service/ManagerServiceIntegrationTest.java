package com.ipiecoles.java.java350.service;

import com.ipiecoles.java.java350.MySpringApplication;
import com.ipiecoles.java.java350.model.Manager;
import com.ipiecoles.java.java350.model.Technicien;
import com.ipiecoles.java.java350.repository.ManagerRepository;
import com.ipiecoles.java.java350.repository.TechnicienRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;

@RunWith(SpringRunner.class)
@SpringBootTest//(classes = MySpringApplication.class)
public class ManagerServiceIntegrationTest {

    @Autowired
    ManagerService managerService;

    @Autowired
    ManagerRepository managerRepository;

    @Autowired
    TechnicienRepository technicienRepository;

    @Test
    public void testAddTechniciens(){
        //Given
        Manager manager = new Manager("Durand", "Jean", "M12345", null, 2000d, new HashSet<>());
        manager = managerRepository.save(manager);

        Technicien technicien = new Technicien("Dupond", "Jacques", "T98765", null, 1000d, 2);
        technicien = technicienRepository.save(technicien);

        //When
        managerService.addTechniciens(manager.getId(), technicien.getMatricule());

        //Then
        Manager finalManager = managerRepository.findOneWithEquipeById(manager.getId());
        Technicien finalTechnicien = technicienRepository.findOne(technicien.getId());

        Assertions.assertThat(finalManager.getEquipe().contains(finalTechnicien));
        Assertions.assertThat(finalTechnicien.getManager()).isNotNull();
        Assertions.assertThat(finalTechnicien.getManager()).isEqualTo(finalManager);
    }


}
