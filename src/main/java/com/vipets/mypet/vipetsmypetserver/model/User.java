package com.vipets.mypet.vipetsmypetserver.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	private String name;
	private String surname;
	private byte[] photo;
	private String email;
	private String password;
	private LocalDateTime registrationDate;
	private LocalDateTime lastChangeDate;
	private boolean admin;
	private boolean employee;
	private boolean client;
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToMany
	@JoinTable(name = "pet_owner", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "pet_id"))
	private List<Pet> pets;
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToMany
	@JoinTable(name = "user_petshop", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "petshop_id"))
	private List<Petshop> petshops;

}
