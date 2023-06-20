package com.usach.movie_backend.profile.repository;


import com.usach.movie_backend.profile.domain.ProfileMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IProfileMovieRepository extends JpaRepository<ProfileMovie,Integer> {

    List<ProfileMovie> findAll();

    @Query("SELECT p FROM ProfileMovie p WHERE  p.idProfile = :idProfile AND p.idMovie = :idMovie")
    Optional<ProfileMovie> findProfileMovieByIdProfileAndIdMovie(@Param("idProfile") Integer IdProfile,@Param("idMovie") Integer idMovie);


}
