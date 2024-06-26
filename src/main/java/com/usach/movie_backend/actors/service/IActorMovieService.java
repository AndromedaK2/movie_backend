package com.usach.movie_backend.actors.service;

import com.usach.movie_backend.actors.domain.ActorMovie;

import java.util.List;
import java.util.Optional;

public interface IActorMovieService<T>{

    List<ActorMovie> findAll();

    Optional<ActorMovie> findByActorMovie(Integer idActorMovie);

    ActorMovie create(ActorMovie actorMovie);

    ActorMovie update(ActorMovie actorMovie);

    void delete(Integer idActorMovie);
}
