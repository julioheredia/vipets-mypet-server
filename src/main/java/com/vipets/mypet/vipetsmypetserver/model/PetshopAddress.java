package com.vipets.mypet.vipetsmypetserver.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class PetshopAddress implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long petshopAddressId;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "petshop_id", nullable = false)
	private Petshop petshop;
	private Long zipCode;
	private Country country;
	private State state;
	private City city;
	private String district;
	private String neighborhood;
	private String address;
	private String number;
	private String additionalInformation;

}
