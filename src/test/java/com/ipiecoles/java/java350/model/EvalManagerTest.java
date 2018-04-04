package com.ipiecoles.java.java350.model;



import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.Test;
import org.mockito.asm.tree.TryCatchBlockNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ipiecoles.java.java350.exception.EmployeException;
import com.ipiecoles.java.java350.model.Commercial;
import com.ipiecoles.java.java350.model.Entreprise;
import com.ipiecoles.java.java350.model.Manager;
import com.ipiecoles.java.java350.model.Technicien;

import cucumber.deps.com.thoughtworks.xstream.security.ForbiddenClassException;

public class EvalManagerTest {
	
	
	Technicien pierreDurand = new Technicien("Durand", "Pierre","C12347",new LocalDate(), 2000d, 1);
	Technicien patrickDupont= new Technicien("Dupont", "Patrick","C12345", new LocalDate(), 2000d, 2);
	Technicien jeanJacques = new Technicien("Jacques", "Jean","C22345", new LocalDate(), 2000d, 2);
	Technicien jacquesDupont = new Technicien("Dupont", "Jacques","C32345", new LocalDate(), 2000d, 1);
	
	HashSet<Technicien> equipe = new HashSet<Technicien>();//equipe vide par défaut

	Manager manager = new Manager("Dubois", "Romain", "M54321", new LocalDate(),null, equipe);//salaire null par défaut
	
	
	
		
    @Test
    public void testSetSalaireManagerEquipe4Pers() {
    	
    	//Given   	
		manager.ajoutTechnicienEquipe(pierreDurand);
		manager.ajoutTechnicienEquipe(patrickDupont);
		manager.ajoutTechnicienEquipe(jeanJacques);
		manager.ajoutTechnicienEquipe(jacquesDupont);
		
		
		Double salaire= 2000d;
		Double expectedSalary;
		expectedSalary=salaire * Entreprise.INDICE_MANAGER + (salaire * (double)equipe.size() / 10);
		
		
		//When
		manager.setSalaire(salaire);
		salaire = manager.getSalaire();
		
		//Then
		Assertions.assertThat(salaire).isEqualTo(expectedSalary);
		
    	
    }
    
    @Test
    public void testSetSalaireManagerEquipe0() {
    	
    	//Given   	
        //equipe vide par défaut
		Double salaire= 2000d;
		Double expectedSalary;
		expectedSalary=salaire * Entreprise.INDICE_MANAGER + (salaire * (double)equipe.size() / 10);
		
		
		//When
		manager.setSalaire(salaire);
		salaire = manager.getSalaire();
		
		//Then
		Assertions.assertThat(salaire).isEqualTo(expectedSalary);
    	
    }
    
}
