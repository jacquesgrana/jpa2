package fr.diginamic.javaFS2022.jpa.banque.entite;

import java.time.LocalDateTime;

import javax.persistence.Entity;

@Entity
public class Virement extends Operation {

	private String beneficiaire;
	
	public Virement() {
		super();
	}

	public Virement(LocalDateTime date, Double montant, String motif) {
		super(date, montant, motif);
	}

	public Virement(LocalDateTime date, Double montant, String motif, Compte compte, String beneficiaire) {
		super(date, montant, motif, compte);
		this.beneficiaire = beneficiaire;
	}

	/**
	 * @return the beneficiaire
	 */
	public String getBeneficiaire() {
		return beneficiaire;
	}

	/**
	 * @param beneficiaire the beneficiaire to set
	 */
	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Virement [beneficiaire=");
		builder.append(beneficiaire);
		builder.append("]");
		return builder.toString();
	}

}
