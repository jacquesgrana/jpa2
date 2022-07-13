package fr.diginamic.javaFS2022.jpa.bo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity(name = "LIVRE")
public class Livre implements Serializable {
	
	

	@Id
	@Column(name = "ID")
	//@IdClass(foo.class)
	private Integer id;
	
	@Column(name = "TITRE")
	private String titre;
	
	@Column(name = "AUTEUR")
	private String auteur;
	
	@OneToMany(mappedBy="livre")
	private Set<Compo> compo_livre;
	
	@ManyToMany(mappedBy="livres")
	private Set<Emprunt> emprunts;

	/**
	 * 
	 */
	public Livre() {}

	
	
	/**
	 * @param titre
	 * @param auteur
	 */
	public Livre(String titre, String auteur) {
		//super();
		this.titre = titre;
		this.auteur = auteur;
	}



	/**
	 * @param id
	 * @param titre
	 * @param auteur
	 */
	public Livre(Integer id, String titre, String auteur) {
		//super();
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * @return the auteur
	 */
	public String getAuteur() {
		return auteur;
	}

	/**
	 * @param auteur the auteur to set
	 */
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Livre [id=");
		builder.append(id);
		builder.append(", titre=");
		builder.append(titre);
		builder.append(", auteur=");
		builder.append(auteur);
		builder.append("]");
		return builder.toString();
	}
	
}
