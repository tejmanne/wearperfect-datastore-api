package com.wearperfect.datastoreapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.wearperfect.datastoreapi.models.Address;

@RestResource
public interface AddressRepository extends JpaRepository<Address, Long>{

}
