package com.vipets.mypet.vipetsmypetserver.model;

import java.io.Serializable;
import java.time.LocalDate;
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

import lombok.Data;

@Entity
@Data
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
	private LocalDate dateRegistration;
	@Column
	private LocalDate dateLastChange;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "animal_petshop", joinColumns = @JoinColumn(name = "petshop_id"), inverseJoinColumns = @JoinColumn(name = "pet_id"))
	private List<Pet> pets;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "user_petshop", joinColumns = @JoinColumn(name = "petshop_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> clients;

}
