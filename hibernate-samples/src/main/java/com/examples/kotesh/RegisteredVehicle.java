package com.examples.kotesh;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@Entity
public class RegisteredVehicle {
	@Id
	private String vehicleId;
	private String vehicleName;
	@ManyToOne
	private RegisteredUser registeredUser;

}
