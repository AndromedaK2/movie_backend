package com.usach.movie_backend.actors.service;

import com.usach.movie_backend.actors.domain.Actor;

import java.util.List;
import java.util.Optional;

public interface IActorService<T>{
    List<Actor> findAll();

    Optional<Actor> findByActor(Integer idActor);

    Actor create(Actor actor);

    Actor update(Actor actor);

    void delete(Integer idActor);
}
