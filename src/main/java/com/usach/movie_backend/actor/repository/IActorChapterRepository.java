package com.usach.movie_backend.actor.repository;

import com.usach.movie_backend.actor.domain.ActorChapter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IActorChapterRepository extends JpaRepository<ActorChapter,Integer> {
    List<ActorChapter>findAll();
}
