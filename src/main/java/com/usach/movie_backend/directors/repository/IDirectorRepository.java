package com.usach.movie_backend.directors.repository;

import com.usach.movie_backend.directors.domain.Director;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDirectorRepository  extends JpaRepository<Director,Integer> {
List<Director> findAll();
}
