package fr.diginamic.javaFS2022.jpa;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.diginamic.javaFS2022.jpa.banque.entite.Adresse;
import fr.diginamic.javaFS2022.jpa.banque.entite.Banque;
import fr.diginamic.javaFS2022.jpa.banque.entite.Client;
import fr.diginamic.javaFS2022.jpa.banque.entite.Compte;
import fr.diginamic.javaFS2022.jpa.banque.entite.Operation;

public class TestBanqueTP4 {

	public static void main(String[] args) {
		
		//Scanner sc = new Scanner(System.in);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_banque");
    	EntityManager em = emf.createEntityManager();
    	System.out.println("connection ok : " + em);
    	
    	em.getTransaction().begin();
    	Banque banque1 = new Banque ("Banque Russe");
    	Banque banque2 = new Banque ("Banque Chinoise");
    	em.persist(banque1);
    	em.persist(banque2);
    	
    	Adresse adresse1 = new Adresse(5, "rue Martin", 99999, "Martinville");
    	em.persist(new Client("Martin", "Martin", LocalDate.of(1977,12, 29), adresse1, banque1));
    	em.persist(new Client("Martin", "Martine", LocalDate.of(1980,01, 12), adresse1, banque2));
    	em.getTransaction().commit();
    	
    	em.getTransaction().begin();
    	Compte compte1 = new Compte("ZA 4522 GFFH", 1000.0d);
    	Compte compte2 = new Compte("RETH 5487 GFD", -250.0d);
    	
    	em.persist(compte1);
    	em.persist(compte2);
    	
    	Client client1 = em.find(Client.class, 3);
    	client1.getComptes().add(compte1);
    	Client client2 = em.find(Client.class, 4);
    	client2.getComptes().add(compte2);
    	
    	em.persist(client1);
    	em.persist(client2);
    	
    	Operation ope1 = new Operation(LocalDateTime.of(2022,05, 02, 15, 25), -500.0d, "Achat alimentaire", compte1);
    	Operation ope2 = new Operation(LocalDateTime.of(2022,06, 10, 16, 00), 100.0d, "Vente d'un chat", compte1);
    	Operation ope3 = new Operation(LocalDateTime.of(2022,07, 17, 18, 00), -75.0d, "Achat d'un rat", compte1);
    	Operation ope4 = new Operation(LocalDateTime.of(2022,06, 12, 16, 35), 300.0d, "Vente d'un chien", compte2);
    	Operation ope5 = new Operation(LocalDateTime.of(2022,07, 13, 11, 10), -2000.0d, "Achat d'un pitbull", compte2);
    	
    	em.persist(ope1);
    	em.persist(ope2);
    	em.persist(ope3);
    	em.persist(ope4);
    	em.persist(ope5);
    	
    	
    	em.getTransaction().commit();
    	em.close();
    	emf.close();

	}

}
