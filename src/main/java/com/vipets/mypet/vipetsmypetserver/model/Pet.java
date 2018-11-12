package com.vipets.mypet.vipetsmypetserver.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
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
import javax.persistence.PostLoad;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vipets.mypet.vipetsmypetserver.util.ImagesUtil;
import com.vipets.mypet.vipetsmypetserver.util.ImagesUtil.ImagePerformerType;
import com.vipets.mypet.vipetsmypetserver.util.ImagesUtil.ImageType;

import lombok.Data;

@Entity
@Data
public class Pet implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long petId;
	private String name;
	@JsonIgnore
	private byte[] photo;
	@Transient
	private String imageName;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "animal_species_id", nullable = false)
	private AnimalSpecies AnimalSpecies;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "breed_id", nullable = false)
	private Breed Breed;
	private String color;
	private String description;
	private String favoriteWalkingPlace;
	private String favoritePlay;
	private String regularFeed;
	private String favoriteFeed;
	private LocalDateTime registrationDate;
	private LocalDateTime lastChangeDate;
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

	@PostLoad
	public void createImage() {
		if (this.photo != null) {
			ImagesUtil.convertByteArrayInImageJpeg(this.photo, ImagePerformerType.Pet, String.valueOf(this.petId));
			this.imageName = ImagesUtil.joinImageName(ImagePerformerType.Pet, String.valueOf(this.petId),
					ImageType.jpeg);
		}
	}

}
