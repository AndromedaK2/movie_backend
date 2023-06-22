package com.usach.movie_backend.genders.repository;


import com.usach.movie_backend.genders.domain.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IGenderRepository extends JpaRepository<Gender,Integer> {

    List<Gender>findAll();

    Optional<Gender> findByNameGender(String nameGender);
}
