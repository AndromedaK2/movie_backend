package com.usach.movie_backend.directors.service;

import com.usach.movie_backend.directors.domain.Director;
import com.usach.movie_backend.directors.repository.IDirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DirectorService  implements  IDirectorService<Director> {

    @Autowired
    private IDirectorRepository iDirectorRepositoryl;
    @Override
    public List<Director> findAll() {
        return iDirectorRepositoryl.findAll();
    }

    @Override
    public Optional<Director> findByDirector(Integer idDirector) {
        return iDirectorRepositoryl.findById(idDirector);
    }

    @Override
    public Director create(Director director) {
        return null;
    }

    @Override
    public Director update(Director director) {
        return null;
    }

    @Override
    public void delete(Integer idDirector) {

    }
}
