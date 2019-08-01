package com.wearperfect.datastoreapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="address")
@Data
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="user_id")
	private long userId;
	
	@Column(name="address_line1")
	private String addressLine1;
	
	@Column(name="address_line2")
	private String addressLine2;
	
	@Column(name="city")
	private long city;
	
	@Column(name="zip_code")
	private int zipCode;
	
	@Column(name="state")
	private int state;
	
	@Column(name="country")
	private int country;
	
	@Column(name="phone")
	private long phone;
	
	@Column(name="phone_country_code")
	private int phoneCountryCode;
	
	@Column(name="active")
	private boolean active;
	
}
