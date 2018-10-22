package com.vipets.mypet.vipetsmypetserver.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Petshop implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long petshopId;
	@Column
	private String name;
	@Column
	private String businessName;
	@Column
	private byte[] logo;
	@Column
	private String email;
	@Column
	private String telephone;
	@Column
	private String telephoneAux;
	@Column
	private Date dateRegistration;
	@Column
	private Date dateLastChange;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "animal_petshop", joinColumns = @JoinColumn(name = "petshop_id"), inverseJoinColumns = @JoinColumn(name = "pet_id"))
	private List<Pet> pets;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "user_petshop", joinColumns = @JoinColumn(name = "petshop_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> clients;

	public long getPetshopId() {
		return petshopId;
	}

	public void setPetshopId(long petshopId) {
		this.petshopId = petshopId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getTelephoneAux() {
		return telephoneAux;
	}

	public void setTelephoneAux(String telephoneAux) {
		this.telephoneAux = telephoneAux;
	}

	public Date getDateRegistration() {
		return dateRegistration;
	}

	public void setDateRegistration(Date dateRegistration) {
		this.dateRegistration = dateRegistration;
	}

	public Date getDateLastChange() {
		return dateLastChange;
	}

	public void setDateLastChange(Date dateLastChange) {
		this.dateLastChange = dateLastChange;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	public List<User> getClients() {
		return clients;
	}

	public void setClients(List<User> clients) {
		this.clients = clients;
	}

}
