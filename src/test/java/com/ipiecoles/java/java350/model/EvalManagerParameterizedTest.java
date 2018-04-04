package com.ipiecoles.java.java350.model;


import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;


import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.ipiecoles.java.java350.model.Manager;
import com.ipiecoles.java.java350.model.Technicien;
import com.ipiecoles.java.java350.service.TechnicienService;

////private void augmenterSalaireEquipe(Double pourcentage) {
//for (Technicien technicien : equipe) {
//	technicien.augmenterSalaire(pourcentage);
//}

@RunWith(value=Parameterized.class)
public class EvalManagerParameterizedTest {
	
	
	@Parameter(value=0)
	public Integer nombreTechnicien;
	@Parameter(value=1)
	public Double expectedSalary;
   	
	
	//Jeu de données
	@Parameters(name="Le salaire attendu pour une équipe de {0} est  {1}")
	public static  Collection<Object[]> Data() {
		return Arrays.asList(new Object[][] {
			{0, 2600d},  
			{1, 2800d},  
			{2, 3000d}, 
			{3, 3200d}, 
			{4, 3400d},
			
		});
	}
	
	
	//Test	
	@Test
	public void testSetSalaireManager() {
		
		//Given
		Manager romainDubois = new Manager("Dubois", "Romain", "M54321", new LocalDate(),null, new HashSet<Technicien>());
		List<Technicien> techniciens = new ArrayList<Technicien>() ;
		techniciens.add(new Technicien("Durand", "Pierre","C12347",new LocalDate(), 2000d, 1));
		techniciens.add(new Technicien("Dubois", "Patrick","C12345", new LocalDate(), 2000d, 2));
		techniciens.add(new Technicien("Dupont", "Patrick","C12345", new LocalDate(), 2000d, 2));
		techniciens.add(new Technicien("Dupont", "Jacques","C32345", new LocalDate(), 2000d, 1));
		
		
		int i=0;
		if (nombreTechnicien>0) {
			while( i<nombreTechnicien)
			{
				
				romainDubois.ajoutTechnicienEquipe(techniciens.get(i));	
				System.out.println(techniciens.get(i) + "  " + romainDubois.getEquipe().size());
				i++;
			}			
		}
		//When
	    romainDubois.setSalaire(2000d);
	    Double salaire=romainDubois.getSalaire();
	    Integer taille=romainDubois.getEquipe().size();
		System.out.println(taille + "  " + nombreTechnicien + " " + salaire + " " + expectedSalary);
	    
		//Then 
		Assertions.assertThat(salaire).isEqualTo(expectedSalary);
		
	}
	}
	
	
