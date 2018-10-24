package com.vipets.mypet.vipetsmypetserver.model;

import java.io.Serializable;

import javax.persistence.Column;
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
	@Column
	private Long zipCode;
	@Column
	private Country country;
	@Column
	private State state;
	@Column
	private City city;
	@Column
	private String district;
	@Column
	private String neighborhood;
	@Column
	private String address;
	@Column
	private String number;
	@Column
	private String additionalInformation;

}
