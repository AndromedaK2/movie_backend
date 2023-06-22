package com.usach.movie_backend.roles.service;

import com.usach.movie_backend.roles.domain.Rol;
import com.usach.movie_backend.roles.repository.IRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class RolService implements IRolService {
    @Autowired
    private IRolRepository rolRepository;

    @Transactional(readOnly = true)
    public Rol findByIdRol(Integer idRol){
        Optional<Rol> rol = rolRepository.findById(idRol);
        if(rol.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Rol not found");
        return rol.get();
    }

    @Transactional(readOnly = true)
    public List<Rol> findAllRoles(){
        return rolRepository.findAll();
    }
}
