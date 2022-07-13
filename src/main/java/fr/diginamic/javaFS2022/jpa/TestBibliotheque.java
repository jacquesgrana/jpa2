package fr.diginamic.javaFS2022.jpa;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.javaFS2022.jpa.bo.Emprunt;
import fr.diginamic.javaFS2022.jpa.bo.Livre;
import fr.diginamic.javaFS2022.jpa.bo.Client;
import fr.diginamic.javaFS2022.jpa.bo.Compo;

public class TestBibliotheque {

	//private static final String SELECT_EMPRUNT_TO_LIVRE_QUERY = "SELECT e, c, l FROM EMPRUNT e JOIN e.compos c JOIN c.livre l WHERE e.id = :id "; //JOIN e.compos c 
	
	
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_local");
    	EntityManager em = emf.createEntityManager();
    	System.out.println("connection ok : " + em);
    	
    	//em.getTransaction().begin();
    	
    	Integer idEmprunt = 2;
    	//TypedQuery<Emprunt> query1 = em.createQuery(SELECT_EMPRUNT_TO_LIVRE_QUERY, Emprunt.class);
    	//query1.setParameter("id", id);
    	//List<Emprunt> objects = query1.getResultList();
    	
    	Emprunt emprunt = em.find(Emprunt.class, idEmprunt);
    	
    	Set<Compo> compos = emprunt.getCompos();
    	
    	System.out.println(emprunt + "\n");
    	for (Compo compo : compos) {
    		System.out.println(compo.getLivre());
    	}
    	
    	Integer idClient = 1;
    	Client client = em.find(Client.class, idClient);
    	
    	System.out.println(client);
    	
    	for(Emprunt emprunt2 : client.getEmprunts()) {
    		System.out.println(emprunt2);
    	}
    	
    	
    	//em.getTransaction().commit();
    	
    	em.close();
    	emf.close();

	}

}
