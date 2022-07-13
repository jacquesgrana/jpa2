package fr.diginamic.javaFS2022.jpa.banque.entite;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class LivretA extends Compte {
	
	@Column
	private Double taux;

	/**
	 * @param numero
	 * @param solde
	 */
	public LivretA() {
		super();
	}

	/**
	 * @param numero
	 * @param solde
	 */
	public LivretA(String numero, Double solde, Double taux) {
		super(numero, solde);
		this.taux = taux;
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
		builder.append("LivretA [taux=");
		builder.append(taux);
		builder.append("]");
		return builder.toString();
	}

}
