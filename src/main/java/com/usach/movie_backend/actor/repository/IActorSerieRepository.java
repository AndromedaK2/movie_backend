package com.usach.movie_backend.actor.repository;

import com.usach.movie_backend.actor.domain.ActorSerie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IActorSerieRepository extends JpaRepository<ActorSerie,Integer> {

    List<ActorSerie> findAll();
}
