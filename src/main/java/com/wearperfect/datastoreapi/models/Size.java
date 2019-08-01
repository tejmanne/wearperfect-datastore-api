package com.wearperfect.datastoreapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="size")
@Data
public class Size {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="short_name")
	private String shortName;
	
	@Column(name="desc")
	private String desc;
	
	@Column(name="us_size")
	private double usSize;
	
	@Column(name="uk_size")
	private double ukSize;
	
	@Column(name="wear_type")
	private double wearType;
	
	@Column(name="active")
	private boolean active;
}