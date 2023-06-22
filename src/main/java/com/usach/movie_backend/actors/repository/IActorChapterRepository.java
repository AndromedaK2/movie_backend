package com.usach.movie_backend.actors.repository;

import com.usach.movie_backend.actors.domain.ActorChapter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IActorChapterRepository extends JpaRepository<ActorChapter,Integer> {
    List<ActorChapter>findAll();
}
