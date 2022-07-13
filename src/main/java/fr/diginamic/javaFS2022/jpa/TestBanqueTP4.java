package fr.diginamic.javaFS2022.jpa;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.diginamic.javaFS2022.jpa.banque.entite.Banque;

public class TestBanqueTP4 {

	public static void main(String[] args) {
		
		//Scanner sc = new Scanner(System.in);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_banque");
    	EntityManager em = emf.createEntityManager();
    	System.out.println("connection ok : " + em);
    	
    	em.getTransaction().begin();
    	//Banque banque1 = ;
    	em.persist(new Banque ("Banque Russe"));
    	em.persist(new Banque ("Banque Chinoise"));
    	
    	
    	em.getTransaction().commit();
    	em.close();
    	emf.close();

	}

}
