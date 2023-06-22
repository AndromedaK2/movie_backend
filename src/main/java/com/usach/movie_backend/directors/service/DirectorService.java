package com.usach.movie_backend.directors.service;

import com.usach.movie_backend.directors.domain.Director;
import com.usach.movie_backend.directors.repository.IDirectorRepository;
import com.usach.movie_backend.directors.service.dto.DirectorCreate;
import com.usach.movie_backend.directors.service.dto.DirectorUpdate;
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

    @Transactional(noRollbackFor = {ResponseStatusException.class})
    public Director create(DirectorCreate directorCreate) {
        if(directorRepository.findByFirstNameAndLastName(directorCreate.firstName(), directorCreate.lastName()).isPresent())
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Director already created");
        Director director = new Director();
        director.setFirstName(directorCreate.firstName());
        director.setLastName(directorCreate.lastName());
        director.setBirthday(directorCreate.birthdate());
        director.setNationality(directorCreate.nationality());
        director.setUrlPhoto(directorCreate.urlPhoto());
        return directorRepository.save(director);
    }

    @Transactional(noRollbackFor = {ResponseStatusException.class})
    public Director update(DirectorUpdate directorUpdate) {
        Director director = findByFirstNameAndLastName(directorUpdate.firstName(), directorUpdate.lastName());
        director.setFirstName(directorUpdate.firstName());
        director.setLastName(directorUpdate.lastName());
        director.setBirthday(directorUpdate.birthdate());
        director.setNationality(directorUpdate.nationality());
        director.setUrlPhoto(directorUpdate.urlPhoto());
        return directorRepository.save(director);
    }

    @Transactional(noRollbackFor = {ResponseStatusException.class})
    public void delete(Integer idDirector) {
      directorRepository.deleteById(idDirector);
    }


}
