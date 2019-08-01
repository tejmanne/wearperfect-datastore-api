package com.wearperfect.datastoreapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="collection_item")
@Data
public class CollectionItem {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="user_item_id")
	private long userId;
	
	@Column(name="collection_id")
	private long collectionId;
	
	@Column(name="active")
	private boolean active;
}
