package com.wearperfect.datastoreapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wearperfect.datastoreapi.models.User;


@Repository
public interface UserRepository extends JpaRepository<User , Long>{

}
