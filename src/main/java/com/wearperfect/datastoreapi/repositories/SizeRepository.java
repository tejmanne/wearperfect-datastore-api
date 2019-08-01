package com.wearperfect.datastoreapi.repositories;

import com.wearperfect.datastoreapi.models.Size;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface SizeRepository extends JpaRepository<Size, Integer>{

}
