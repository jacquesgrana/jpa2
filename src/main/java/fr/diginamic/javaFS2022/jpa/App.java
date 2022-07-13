package fr.diginamic.javaFS2022.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.javaFS2022.jpa.bo.Livre;

/**
 * Test de connection a la bd
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_local");
    	EntityManager em = emf.createEntityManager();
    	System.out.println("connection ok : " + em);
    	
    	em.getTransaction().begin();
    	
    	Livre livre1 = em.find(Livre.class, 3);
    	System.out.println("livre trouvé : " + livre1.toString());
    	
    	
    	Livre livre2 = new Livre(6, "Les meilleures blagues de toto", "Martin Martin");
    	em.persist(livre2);
    	System.out.println("livre inséré : " + livre2.toString());
    	
    	em.getTransaction().commit();
    	em.getTransaction().begin();
    	/*
    	Livre livre3 = em.find(Livre.class, 5);
    	livre3.setTitre("Du plaisir dans la cuisine");
    	System.out.println("livre modifié : " + livre1.toString());
    	*/
    	
    	String titre = "Germinal";
    	TypedQuery<Livre> query1 = em.createQuery("SELECT l FROM LIVRE l WHERE l.titre='" + titre + "'", Livre.class);
    	Livre livre4 = query1.getResultList().get(0);
    	System.out.println("livre trouvé avec le titre : " + titre + " / : " + livre4.toString());
    	
    	
    	String auteur = "Martin Martin";
    	TypedQuery<Livre> query2 = em.createQuery("SELECT l FROM LIVRE l WHERE l.auteur='" + auteur + "'", Livre.class);
    	Livre livre5 = query2.getResultList().get(0);
    	System.out.println("livre trouvé avec l'auteur : " + auteur + " / : " + livre5.toString());
    	
    	
    	Livre livre6 = em.find(Livre.class, 6);
    	System.out.println("livre à supprimer : " + livre6.toString());
    	em.remove(livre6);
    	
    	//List<Livre> livres = new ArrayList<>();
    	TypedQuery<Livre> query3 = em.createQuery("SELECT l FROM LIVRE l", Livre.class);
    	List<Livre> livres = query3.getResultList();
    	
    	em.getTransaction().commit();
    	
    	System.out.println("Liste des livres : \n");
    	
    	for(Livre livre : livres) {
    		System.out.println(livre.toString());
    	}
    	
    	em.close();
    	emf.close();
    }
}
