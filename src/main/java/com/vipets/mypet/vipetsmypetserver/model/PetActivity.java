package com.vipets.mypet.vipetsmypetserver.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
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
public class PetActivity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long petActivityId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pet_id", nullable = false)
	private Pet pet;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "activity_id", nullable = false)
	private Activity activity;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "petshop_id", nullable = false)
	private Petshop petshop;
	@Column
	private LocalDate clientScheduledTime;
	@Column
	private LocalDate activityStart;
	@Column
	private LocalDate activityEnd;

}
