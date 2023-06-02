package com.usach.movie_backend.actor.service;

import com.usach.movie_backend.actor.domain.ActorChapter;


import java.util.List;
import java.util.Optional;

public interface IActorChapterService<T> {
    List<ActorChapter> findAll();

    Optional<ActorChapter> findByActorChapter(Integer idActorChapter);

    ActorChapter create(ActorChapter actorChapter);

    ActorChapter update(ActorChapter actorChapter);

    void delete(Integer idActorChapter);
}
