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
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	@Column
	private String name;
	@Column
	private String surname;
	@Column
	private byte[] photo;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private LocalDate registrationDate;
	@Column
	private LocalDate lastChangeDate;
	@Column 
	private boolean admin;
	@Column
	private boolean employee;
	@Column
	private boolean client;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "pet_owner", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "pet_id"))
	private List<Pet> pets;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "user_petshop", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "petshop_id"))
	private List<Petshop> petshops;

}
