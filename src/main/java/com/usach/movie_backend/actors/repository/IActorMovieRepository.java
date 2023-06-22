package com.usach.movie_backend.actors.repository;

import com.usach.movie_backend.actors.domain.ActorMovie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IActorMovieRepository extends JpaRepository<ActorMovie,Integer> {

    List<ActorMovie>findAll();
}
