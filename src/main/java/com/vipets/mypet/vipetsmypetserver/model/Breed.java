package com.vipets.mypet.vipetsmypetserver.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Breed implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long breedId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "animal_species_id", nullable = false)
	private AnimalSpecies AnimalSpecies;
	@Column
	private String name;
	@Column
	private String description;
	@Column
	private byte[] exampleImage;

	public long getBreedId() {
		return breedId;
	}

	public void setBreedId(long breedId) {
		this.breedId = breedId;
	}

	public AnimalSpecies getAnimalSpecies() {
		return AnimalSpecies;
	}

	public void setAnimalSpecies(AnimalSpecies animalSpecies) {
		AnimalSpecies = animalSpecies;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getExampleImage() {
		return exampleImage;
	}

	public void setExampleImage(byte[] exampleImage) {
		this.exampleImage = exampleImage;
	}

}
