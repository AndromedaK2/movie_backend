package com.usach.movie_backend.actors.service;

import com.usach.movie_backend.actors.domain.Actor;
import com.usach.movie_backend.actors.repository.IActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService implements IActorService<Actor> {
    @Autowired
    private IActorRepository iActorRepository;
    @Override
    public List<Actor> findAll() {
        return iActorRepository.findAll();
    }

    @Override
    public Optional<Actor> findByActor(Integer idActor) {
        return iActorRepository.findById(idActor);
    }

    @Override
    public Actor create(Actor actor) {
        return iActorRepository.save(actor);
    }

    @Override
    public Actor update(Actor actor) {
        return iActorRepository.save(actor);
    }

    @Override
    public void delete(Integer idActor) {
        iActorRepository.deleteById(idActor);
    }
}
