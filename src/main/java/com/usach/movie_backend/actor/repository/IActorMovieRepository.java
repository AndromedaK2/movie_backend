package com.usach.movie_backend.actor.repository;

import com.usach.movie_backend.actor.domain.ActorMovie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IActorMovieRepository extends JpaRepository<ActorMovie,Integer> {

    List<ActorMovie>findAll();
}
