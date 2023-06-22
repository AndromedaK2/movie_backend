package com.usach.movie_backend.actors.repository;

import com.usach.movie_backend.actors.domain.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IActorRepository extends JpaRepository<Actor,Integer> {

    List<Actor> findAll();
}
