package fr.diginamic.javaFS2022.jpa.banque.entite;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Client {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String nom;
	
	@Column
	private String prenom;
	
	@Column
	private LocalDate dateNaissance;
	
	@Embedded
	private Adresse adresse;
	
	@ManyToOne
	private Banque banque;
	
	@ManyToMany
	@JoinTable(name="Possede",
	joinColumns= @JoinColumn(name="id_client", referencedColumnName="id"),
	inverseJoinColumns= @JoinColumn(name="id_compte", referencedColumnName="id"))
	private Set<Compte> comptes;

	/**
	 * 
	 */
	public Client() {
		super();
	}

	/**
	 * @param nom
	 * @param prenom
	 * @param dateNaissance
	 * @param adresse
	 */
	public Client(String nom, String prenom, LocalDate dateNaissance, Adresse adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
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
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the dateNaissance
	 */
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	/**
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/**
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
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
	 * @return the banque
	 */
	public Banque getBanque() {
		return banque;
	}

	/**
	 * @param banque the banque to set
	 */
	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	/**
	 * @return the comptes
	 */
	public Set<Compte> getComptes() {
		return comptes;
	}

	/**
	 * @param comptes the comptes to set
	 */
	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Client [id=");
		builder.append(id);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", prenom=");
		builder.append(prenom);
		builder.append(", dateNaissance=");
		builder.append(dateNaissance);
		builder.append(", adresse=");
		builder.append(adresse);
		builder.append("]");
		return builder.toString();
	}

}
