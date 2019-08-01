package com.wearperfect.datastoreapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.wearperfect.datastoreapi.models.UserItem;

@RestResource
public interface UserItemRepository extends JpaRepository<UserItem, Long>{

}
