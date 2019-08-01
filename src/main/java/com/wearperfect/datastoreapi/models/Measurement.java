package com.wearperfect.datastoreapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="measurement")
@Data
public class Measurement {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="desc")
	private String desc;
	
	@Column(name="user_id")
	private long userId;
	
	@Column(name="height")
	private double height;
	
	@Column(name="weight")
	private double weight;
	
	@Column(name="shoulders")
	private double shoulders;
	
	@Column(name="chest")
	private double chest;
	
	@Column(name="sleeve_length")
	private double sleeveLength;
	
	@Column(name="waist")
	private double waist;
	
	@Column(name="trunk_length")
	private double trunkLength;
	
	@Column(name="foot_length")
	private int footLength;
	
	@Column(name="pref_topwear_size")
	private double prefTopwearSize;
	
	@Column(name="pref_bottomwear_size")
	private int prefBottomwearSize;
	
	@Column(name="pref_footwear_size")
	private int prefFootwearSize;
	
	@Column(name="active")
	private boolean active;
}
