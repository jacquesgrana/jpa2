package fr.diginamic.javaFS2022.jpa.banque.entite;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class AssuranceVie extends Compte {

	@Column
	private LocalDate dateFin;
	
	@Column
	private Double taux;
	
	public AssuranceVie() {
		super();
	}

	public AssuranceVie(String numero, Double solde, LocalDate dateFin, Double taux) {
		super(numero, solde);
		this.dateFin = dateFin;
		this.taux = taux;
	}

	/**
	 * @return the dateFin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}

	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * @return the taux
	 */
	public Double getTaux() {
		return taux;
	}

	/**
	 * @param taux the taux to set
	 */
	public void setTaux(Double taux) {
		this.taux = taux;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AssuranceVie [dateFin=");
		builder.append(dateFin);
		builder.append(", taux=");
		builder.append(taux);
		builder.append("]");
		return builder.toString();
	}

}
