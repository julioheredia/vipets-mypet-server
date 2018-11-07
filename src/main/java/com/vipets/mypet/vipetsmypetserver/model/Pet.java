package com.vipets.mypet.vipetsmypetserver.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Pet implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long petId;
	@Column
	private String name;

	@JsonIgnore
	@Column
	private byte[] photo;

//	@Transient
//	private String image;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "animal_species_id", nullable = false)
	private AnimalSpecies AnimalSpecies;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "breed_id", nullable = false)
	private Breed Breed;

	@Column
	private String color;
	@Column
	private String description;
	@Column
	private String favoriteWalkingPlace;
	@Column
	private String favoritePlay;
	@Column
	private String regularFeed;
	@Column
	private String favoriteFeed;
	@Column
	private LocalDate registrationDate;
	@Column
	private LocalDate lastChangeDate;
	@Column
	private LocalDate birthDate;

	@JsonIgnore
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "animal_petshop", joinColumns = @JoinColumn(name = "pet_id"), inverseJoinColumns = @JoinColumn(name = "petshop_id"))
	private List<Petshop> petshops;

	@JsonIgnore
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "pet_owner", joinColumns = @JoinColumn(name = "pet_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> owners;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY)
	private List<PetActivity> petActivitys;

//	@PostLoad
//	public void convertImage() {
//		if (this.photo != null)
//			this.image = ImagesUtil.convertByteArrayToFile(this.photo, "pet" + this.petId);
//	}

}
