package com.vipets.mypet.vipetsmypetserver.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Petshop implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long petshopId;
	private String name;
	private String businessName;
	private byte[] logo;
	private String email;
	private String telephone;
	private String telephoneAux;
	private LocalDateTime dateRegistration;
	private LocalDateTime dateLastChange;
	@JsonIgnore
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "animal_petshop", joinColumns = @JoinColumn(name = "petshop_id"), inverseJoinColumns = @JoinColumn(name = "pet_id"))
	private List<Pet> pets;
	@JsonIgnore
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "user_petshop", joinColumns = @JoinColumn(name = "petshop_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> clients;

}
