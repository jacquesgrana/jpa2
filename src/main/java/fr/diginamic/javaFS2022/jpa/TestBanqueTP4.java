package fr.diginamic.javaFS2022.jpa;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.javaFS2022.jpa.banque.entite.Adresse;
import fr.diginamic.javaFS2022.jpa.banque.entite.AssuranceVie;
import fr.diginamic.javaFS2022.jpa.banque.entite.Banque;
import fr.diginamic.javaFS2022.jpa.banque.entite.Client;
import fr.diginamic.javaFS2022.jpa.banque.entite.Compte;
import fr.diginamic.javaFS2022.jpa.banque.entite.LivretA;
import fr.diginamic.javaFS2022.jpa.banque.entite.Operation;
import fr.diginamic.javaFS2022.jpa.banque.entite.Virement;

public class TestBanqueTP4 {
	
	//SELECT c FROM Compte c JOIN c.
	private static final String SELECT_COMPTES_FROM_CLIENT = "SELECT c FROM Compte c JOIN c.clients cl WHERE cl.id = :id ";

	public static void main(String[] args) {
		
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
    	
    	Compte compte3 = new Compte("Compte joint 44582 fggh 45", 15000.0d);
    	client1.getComptes().add(compte3);
    	client2.getComptes().add(compte3);
    	
    	em.persist(compte3);
    	
    	
    	
    	Adresse adresse2 = new Adresse(10, "rue de la Soif", 34000, "Montpellier");
    	Client client3 = new Client("Dupont", "Alfred", LocalDate.of(1972,02, 18), adresse2, banque2);
    	AssuranceVie assuvie1 = new AssuranceVie("gghyyt 5542 dd", 2000.0d, LocalDate.of(2025,01, 01), 0.25d);
    	LivretA livretA1 = new LivretA("GGHTY4527", 500.0d, 0.05d);
    	
    	em.persist(assuvie1);
    	em.persist(livretA1);
    	
    	
    	client3.getComptes().add(assuvie1);
    	client3.getComptes().add(livretA1);
    	
    	em.persist(client3);
    	
    	Virement vir1 = new Virement(LocalDateTime.of(2022,07, 17, 18, 00), -50000d, "achat bitcoins", compte3, "Durand Jean");
    	Virement vir2 = new Virement(LocalDateTime.of(2022,06, 03, 11, 00), -10000d, "achat ethers", compte3, "Durand Jean");
    	Operation ope6 = new Operation(LocalDateTime.of(2022,07, 13, 11, 10), 3000.d, "Vente d'un rein", compte3);
    	Operation ope7 = new Operation(LocalDateTime.of(2022,06, 20, 11, 10), 60000.d, "Avance sur salaire", compte3);
    	
    	em.persist(vir1);
    	em.persist(vir2);
    	em.persist(ope6);
    	em.persist(ope7);
    	
    	em.getTransaction().commit();
    	
    	Integer idEmprunt = 15;
    	TypedQuery<Compte> query1 = em.createQuery(SELECT_COMPTES_FROM_CLIENT, Compte.class);
    	query1.setParameter("id", idEmprunt);
    	List<Compte> comptes = query1.getResultList();
    	
    	for(Compte compte : comptes) {
    		System.out.println(compte);
    	}
    	
    	
    	em.close();
    	emf.close();

	}

}
