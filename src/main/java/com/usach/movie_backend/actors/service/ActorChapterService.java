package com.usach.movie_backend.actors.service;

import com.usach.movie_backend.actors.domain.ActorChapter;
import com.usach.movie_backend.actors.repository.IActorChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ActorChapterService implements IActorChapterService<ActorChapter> {
    @Autowired
    private IActorChapterRepository iActorChapterRepository;
    @Override
    public List<ActorChapter> findAll() {
        return iActorChapterRepository.findAll();
    }

    @Override
    public Optional<ActorChapter> findByActorChapter(Integer idActorChapter) {
        return iActorChapterRepository.findById(idActorChapter);
    }

    @Override
    public ActorChapter create(ActorChapter actorChapter) {
        return iActorChapterRepository.save(actorChapter);
    }

    @Override
    public ActorChapter update(ActorChapter actorChapter) {
        return iActorChapterRepository.save(actorChapter);
    }

    @Override
    public void delete(Integer idActorChapter) {

        iActorChapterRepository.deleteById(idActorChapter);
    }
}
