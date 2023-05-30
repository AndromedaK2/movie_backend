package com.usach.movie_backend.rol.service;

import com.usach.movie_backend.rol.domain.Rol;
import com.usach.movie_backend.rol.repository.IRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService implements IRolService {
    @Autowired
    private IRolRepository rolRepository;


    public Optional<Rol> findByIdRol(Integer idRol){
        return rolRepository.findById(idRol);
    }

    public List<Rol> findAllRoles(){
        return rolRepository.findAll();
    }
}
