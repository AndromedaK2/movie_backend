package com.usach.movie_backend.actors.service;

import com.usach.movie_backend.actors.domain.ActorSerie;

import java.util.List;
import java.util.Optional;

public interface IActorSerieService<T> {
    List<ActorSerie> findAll();

    Optional<ActorSerie> findByActorSerie(Integer idActorSerie);

    ActorSerie create(ActorSerie actorSerie);

    ActorSerie update(ActorSerie actorSerie);

    void delete(Integer idActorSerie);
}
