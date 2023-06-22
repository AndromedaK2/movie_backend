package com.usach.movie_backend.profiles.repository;

import com.usach.movie_backend.profiles.domain.ProfileSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IProfileSerieRepository extends JpaRepository<ProfileSerie,Integer> {

    List<ProfileSerie> findAll();
    @Query("SELECT p FROM ProfileSerie p WHERE  p.idProfile = :idProfile AND p.idSerie = :idSerie")
    Optional<ProfileSerie> findProfileSerieByIdProfileAndIdMovie(@Param("idProfile") Integer IdProfile, @Param("idSerie") Integer idSerie);

}
