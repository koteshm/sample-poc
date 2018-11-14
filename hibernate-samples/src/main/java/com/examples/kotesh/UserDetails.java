package com.examples.kotesh;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
@Entity
public class UserDetails {
	
	@Column(name="user_id")
	@Id
	private int userId;
	
	@Column(name="user_name")
	private String userName;	

	@AttributeOverride(name="state", column=@Column(name="home_state"))
    private Address adress;

}
