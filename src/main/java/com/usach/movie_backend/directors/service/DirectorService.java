package com.usach.movie_backend.directors.service;

import com.usach.movie_backend.directors.domain.Director;
import com.usach.movie_backend.directors.repository.IDirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
@Service
public class DirectorService  implements  IDirectorService {

    @Autowired
    private IDirectorRepository directorRepository;
    @Transactional(readOnly = true)
    public List<Director> findAll() {
        return directorRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Director> findByDirector(Integer idDirector) {
        return directorRepository.findById(idDirector);
    }

    @Transactional(readOnly = true)
    public Director findByFirstNameAndLastName(String firstName, String lastName) {
        Optional<Director> director =  directorRepository.findByFirstNameAndLastName(firstName,lastName);
        if(director.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Director not found");
        return director.get();
    }

    @Override
    public Director create(Director director) {
        return directorRepository.save(director);
    }

    @Override
    public Director update(Director director) {
        return directorRepository.save(director);
    }

    @Override
    public void delete(Integer idDirector) {
    directorRepository.deleteById(idDirector);
    }


}
