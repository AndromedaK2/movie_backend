package com.usach.movie_backend.actors.service;

import com.usach.movie_backend.actors.domain.ActorMovie;
import com.usach.movie_backend.actors.repository.IActorMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ActorMovieService implements IActorMovieService<ActorMovie> {
    @Autowired
    private IActorMovieRepository iActorMovieRepository;
    @Override
    public List<ActorMovie> findAll() {
        return iActorMovieRepository.findAll();
    }

    @Override
    public Optional<ActorMovie> findByActorMovie(Integer idActorMovie) {
        return iActorMovieRepository.findById(idActorMovie);
    }

    @Override
    public ActorMovie create(ActorMovie actorMovie) {
        return iActorMovieRepository.save(actorMovie);
    }

    @Override
    public ActorMovie update(ActorMovie actorMovie) {
        return iActorMovieRepository.save(actorMovie);
    }

    @Override
    public void delete(Integer idActorMovie) {

        iActorMovieRepository.deleteById(idActorMovie);
    }
}
