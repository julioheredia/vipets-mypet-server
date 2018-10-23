package com.vipets.mypet.vipetsmypetserver.model;

import java.io.Serializable;
import java.util.Date;
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

@Entity
public class Pet implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long petId;
	@Column
	private String name;
	@Column
	private byte[] photo;
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
	private Date registrationDate;
	@Column
	private Date lastChangeDate;
	@Column
	private Date birthDate;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "animal_petshop", joinColumns = @JoinColumn(name = "pet_id"), inverseJoinColumns = @JoinColumn(name = "petshop_id"))
	private List<Petshop> petshops;
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "pet_owner", joinColumns = @JoinColumn(name = "pet_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> owners;

	public long getPetId() {
		return petId;
	}

	public void setPetId(long petId) {
		this.petId = petId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public AnimalSpecies getAnimalSpecies() {
		return AnimalSpecies;
	}

	public void setAnimalSpecies(AnimalSpecies animalSpecies) {
		AnimalSpecies = animalSpecies;
	}

	public Breed getBreed() {
		return Breed;
	}

	public void setBreed(Breed breed) {
		Breed = breed;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFavoriteWalkingPlace() {
		return favoriteWalkingPlace;
	}

	public void setFavoriteWalkingPlace(String favoriteWalkingPlace) {
		this.favoriteWalkingPlace = favoriteWalkingPlace;
	}

	public String getFavoritePlay() {
		return favoritePlay;
	}

	public void setFavoritePlay(String favoritePlay) {
		this.favoritePlay = favoritePlay;
	}

	public String getRegularFeed() {
		return regularFeed;
	}

	public void setRegularFeed(String regularFeed) {
		this.regularFeed = regularFeed;
	}

	public String getFavoriteFeed() {
		return favoriteFeed;
	}

	public void setFavoriteFeed(String favoriteFeed) {
		this.favoriteFeed = favoriteFeed;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Date getLastChangeDate() {
		return lastChangeDate;
	}

	public void setLastChangeDate(Date lastChangeDate) {
		this.lastChangeDate = lastChangeDate;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public List<Petshop> getPetshops() {
		return petshops;
	}

	public void setPetshops(List<Petshop> petshops) {
		this.petshops = petshops;
	}

}
