package fr.diginamic.javaFS2022.jpa.bo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "EMPRUNT")
public class Emprunt implements Serializable {

	@Id
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "DATE_DEBUT")
	private Date date_debut;
	
	@Column(name = "DATE_FIN")
	private Date date_fin;
	
	@Column(name = "DELAI")
	private Integer delai;
	
	@ManyToOne
	@JoinColumn(name = "ID_CLIENT")
	private Client client;
	
	@OneToMany(mappedBy="emprunt")
	private Set<Compo> compos;

	@ManyToMany
	@JoinTable(name="COMPO_EMPRUNT",
			joinColumns= @JoinColumn(name="ID_EMP", referencedColumnName="ID"),
			inverseJoinColumns= @JoinColumn(name="ID_LIV", referencedColumnName="ID"))
	private Set<Livre> livres;

	/**
	 * 
	 */
	public Emprunt() {
		//super();
	}


	/**
	 * @param date_debut
	 * @param date_fin
	 * @param delai
	 * @param client
	 */
	public Emprunt(Date date_debut, Date date_fin, Integer delai, Client client) {
		//super();
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.delai = delai;
		this.client = client;
	}


	/**
	 * @param id
	 * @param date_debut
	 * @param date_fin
	 * @param delai
	 * @param client
	 */
	public Emprunt(Integer id, Date date_debut, Date date_fin, Integer delai, Client client) {
		//super();
		this.id = id;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.delai = delai;
		this.client = client;
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
	 * @return the date_debut
	 */
	public Date getDate_debut() {
		return date_debut;
	}


	/**
	 * @param date_debut the date_debut to set
	 */
	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}


	/**
	 * @return the date_fin
	 */
	public Date getDate_fin() {
		return date_fin;
	}


	/**
	 * @param date_fin the date_fin to set
	 */
	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}


	/**
	 * @return the delai
	 */
	public Integer getDelai() {
		return delai;
	}


	/**
	 * @param delai the delai to set
	 */
	public void setDelai(Integer delai) {
		this.delai = delai;
	}


	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}


	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}
	
	


	/**
	 * @return the compos
	 */
	public Set<Compo> getCompos() {
		return compos;
	}


	/**
	 * @param compos the compos to set
	 */
	public void setCompos(Set<Compo> compos) {
		this.compos = compos;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Emprunt [id=");
		builder.append(id);
		builder.append(", date_debut=");
		builder.append(date_debut);
		builder.append(", date_fin=");
		builder.append(date_fin);
		builder.append(", delai=");
		builder.append(delai);
		builder.append(", client=");
		builder.append(client);
		builder.append("]");
		return builder.toString();
	}

}
