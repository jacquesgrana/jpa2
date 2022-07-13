package fr.diginamic.javaFS2022.jpa.banque.entite;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Banque {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String nom;
	
	@OneToMany(mappedBy="banque")
	private Set<Client> client = new HashSet<>();

	/**
	 * 
	 */
	public Banque() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param nom
	 */
	public Banque(String nom) {
		super();
		this.nom = nom;
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
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	

	/**
	 * @return the client
	 */
	public Set<Client> getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Set<Client> client) {
		this.client = client;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Banque [nom=");
		builder.append(nom);
		builder.append("]");
		return builder.toString();
	}

}
