package com.usach.movie_backend.directors.repository;

import com.usach.movie_backend.directors.domain.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IDirectorRepository  extends JpaRepository<Director,Integer> {
    List<Director> findAll();

    @Query("SELECT d FROM Director d WHERE LOWER(d.firstName) = LOWER(:firstName) AND LOWER(d.lastName) = LOWER(:lastName)")
    Optional<Director> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);
}
