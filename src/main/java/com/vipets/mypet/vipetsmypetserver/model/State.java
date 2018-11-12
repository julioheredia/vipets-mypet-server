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
public class State implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long stateId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "country_id", nullable = false)
	private Country country;
	private String description;
	private String stateCode;
	private String telStateCode;
	private String active;

}
