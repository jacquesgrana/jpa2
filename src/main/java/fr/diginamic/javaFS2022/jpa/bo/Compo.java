package fr.diginamic.javaFS2022.jpa.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "COMPO")
public class Compo implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "ID_LIV")
	private Livre livre;
	
	@ManyToOne
	@JoinColumn(name = "ID_EMP")
	private Emprunt emprunt;

	/**
	 * 
	 */
	public Compo() {
		//super();
	}

	/**
	 * @param livre
	 * @param emprunt
	 */
	public Compo(Livre livre, Emprunt emprunt) {
		//super();
		this.livre = livre;
		this.emprunt = emprunt;
	}

	/**
	 * @param id
	 * @param livre
	 * @param emprunt
	 */
	public Compo(Integer id, Livre livre, Emprunt emprunt) {
		//super();
		this.id = id;
		this.livre = livre;
		this.emprunt = emprunt;
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
	 * @return the livre
	 */
	public Livre getLivre() {
		return livre;
	}

	/**
	 * @param livre the livre to set
	 */
	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	/**
	 * @return the emprunt
	 */
	public Emprunt getEmprunt() {
		return emprunt;
	}

	/**
	 * @param emprunt the emprunt to set
	 */
	public void setEmprunt(Emprunt emprunt) {
		this.emprunt = emprunt;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Compo [id=");
		builder.append(id);
		builder.append(", livre=");
		builder.append(livre);
		builder.append(", emprunt=");
		builder.append(emprunt);
		builder.append("]");
		return builder.toString();
	}

}
