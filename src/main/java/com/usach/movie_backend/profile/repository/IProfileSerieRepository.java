package com.usach.movie_backend.profile.repository;


import com.usach.movie_backend.profile.domain.ProfileSerie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProfileSerieRepository extends JpaRepository<ProfileSerie,Integer> {

    List<ProfileSerie> findAll();
}
