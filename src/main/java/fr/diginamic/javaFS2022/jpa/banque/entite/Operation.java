package fr.diginamic.javaFS2022.jpa.banque.entite;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Operation {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private LocalDateTime date;
	
	@Column
	private Double montant;
	
	@Column
	private String motif;
	
	@ManyToOne
	private Compte compte;

	/**
	 * 
	 */
	public Operation() {
		super();
	}

	/**
	 * @param date
	 * @param montant
	 * @param motif
	 */
	public Operation(LocalDateTime date, Double montant, String motif) {
		super();
		this.date = date;
		this.montant = montant;
		this.motif = motif;
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
	 * @return the date
	 */
	public LocalDateTime getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	/**
	 * @return the montant
	 */
	public Double getMontant() {
		return montant;
	}

	/**
	 * @param montant the montant to set
	 */
	public void setMontant(Double montant) {
		this.montant = montant;
	}

	/**
	 * @return the motif
	 */
	public String getMotif() {
		return motif;
	}

	/**
	 * @param motif the motif to set
	 */
	public void setMotif(String motif) {
		this.motif = motif;
	}

	/**
	 * @return the compte
	 */
	public Compte getCompte() {
		return compte;
	}

	/**
	 * @param compte the compte to set
	 */
	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Operation [id=");
		builder.append(id);
		builder.append(", date=");
		builder.append(date);
		builder.append(", montant=");
		builder.append(montant);
		builder.append(", motif=");
		builder.append(motif);
		builder.append("]");
		return builder.toString();
	}
	
}
