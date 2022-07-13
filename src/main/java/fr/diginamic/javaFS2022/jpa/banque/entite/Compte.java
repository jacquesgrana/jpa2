package fr.diginamic.javaFS2022.jpa.banque.entite;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Compte {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String numero;
	
	@Column
	private Double solde;
	
	@ManyToMany(mappedBy="comptes")
	private Set<Client> clients;
	
	@OneToMany(mappedBy="compte")
	private Set<Operation> operations;

	/**
	 * 
	 */
	public Compte() {
		super();
	}

	/**
	 * @param numero
	 * @param solde
	 */
	public Compte(String numero, Double solde) {
		super();
		this.numero = numero;
		this.solde = solde;
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
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return the solde
	 */
	public Double getSolde() {
		return solde;
	}

	/**
	 * @param solde the solde to set
	 */
	public void setSolde(Double solde) {
		this.solde = solde;
	}
	
	

	/**
	 * @return the clients
	 */
	public Set<Client> getClients() {
		return clients;
	}

	/**
	 * @param clients the clients to set
	 */
	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	/**
	 * @return the operations
	 */
	public Set<Operation> getOperations() {
		return operations;
	}

	/**
	 * @param operations the operations to set
	 */
	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Compte [id=");
		builder.append(id);
		builder.append(", numero=");
		builder.append(numero);
		builder.append(", solde=");
		builder.append(solde);
		builder.append("]");
		return builder.toString();
	}
	
}
