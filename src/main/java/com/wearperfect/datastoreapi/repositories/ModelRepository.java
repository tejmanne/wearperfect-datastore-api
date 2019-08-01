package com.wearperfect.datastoreapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.wearperfect.datastoreapi.models.Model;

@RestResource
public interface ModelRepository extends JpaRepository<Model, Long>{

}
