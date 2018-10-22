package com.vipets.mypet.vipetsmypetserver.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PetActivity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long petActivityId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	private User User;
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
	private Date clientScheduledTime;
	@Column
	private Date activityStart;
	@Column
	private Date activityEnd;

	public long getPetActivityId() {
		return petActivityId;
	}

	public void setPetActivityId(long petActivityId) {
		this.petActivityId = petActivityId;
	}

	public User getUser() {
		return User;
	}

	public void setUser(User user) {
		User = user;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Petshop getPetshop() {
		return petshop;
	}

	public void setPetshop(Petshop petshop) {
		this.petshop = petshop;
	}

	public Date getClientScheduledTime() {
		return clientScheduledTime;
	}

	public void setClientScheduledTime(Date clientScheduledTime) {
		this.clientScheduledTime = clientScheduledTime;
	}

	public Date getActivityStart() {
		return activityStart;
	}

	public void setActivityStart(Date activityStart) {
		this.activityStart = activityStart;
	}

	public Date getActivityEnd() {
		return activityEnd;
	}

	public void setActivityEnd(Date activityEnd) {
		this.activityEnd = activityEnd;
	}

}
