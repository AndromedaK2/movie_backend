package com.usach.movie_backend.rol.service;

import com.usach.movie_backend.rol.domain.Rol;

import java.util.List;
import java.util.Optional;

public interface IRolService {
    Optional<Rol> findByIdRol(Integer idRol);

    List<Rol> findAllRoles();
}
