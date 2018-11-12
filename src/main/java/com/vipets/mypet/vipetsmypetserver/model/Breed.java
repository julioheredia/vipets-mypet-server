package com.vipets.mypet.vipetsmypetserver.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Breed implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long breedId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "animal_species_id", nullable = false)
	private AnimalSpecies AnimalSpecies;
	private String name;
	private String description;
	private byte[] exampleImage;

}
