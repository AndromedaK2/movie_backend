package com.usach.movie_backend.perfil.repository;


import com.usach.movie_backend.perfil.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProfileRepository extends JpaRepository<Profile, Integer> {

    List<Profile> findAll();

}
