package com.usach.movie_backend.actors.service;

import com.usach.movie_backend.actors.domain.ActorSerie;
import com.usach.movie_backend.actors.repository.IActorSerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ActorSerieService implements IActorSerieService<ActorSerie> {
    @Autowired
    private IActorSerieRepository iActorSerieService;

    @Override
    public List<ActorSerie> findAll() {
        return iActorSerieService.findAll();
    }

    @Override
    public Optional<ActorSerie> findByActorSerie(Integer idActorSerie) {
        return iActorSerieService.findById(idActorSerie);
    }

    @Override
    public ActorSerie create(ActorSerie actorSerie) {
        return iActorSerieService.save(actorSerie);
    }

    @Override
    public ActorSerie update(ActorSerie actorSerie) {
        return iActorSerieService.save(actorSerie);
    }

    @Override
    public void delete(Integer idActorSerie) {

        iActorSerieService.deleteById(idActorSerie);
    }
}
