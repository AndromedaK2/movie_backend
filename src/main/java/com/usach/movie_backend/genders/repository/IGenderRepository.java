package com.usach.movie_backend.genders.repository;


import com.usach.movie_backend.genders.domain.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IGenderRepository extends JpaRepository<Gender,Integer> {

    List<Gender>findAll();
}
