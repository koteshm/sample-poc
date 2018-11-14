package com.examples.kotesh;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@Entity
public class RegisteredUser {
    
	@Id
	private String registeredUserId;
	private String userName;
	@OneToMany()
	@Cascade(CascadeType.ALL)
	@JoinTable(name="Registration")
	private List<RegisteredVehicle> registeredVehicle = new ArrayList<>();
}
