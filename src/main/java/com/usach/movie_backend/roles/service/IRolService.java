package com.usach.movie_backend.roles.service;

import com.usach.movie_backend.roles.domain.Rol;

import java.util.List;
import java.util.Optional;

public interface IRolService {
    Rol findByIdRol(Integer idRol);

    List<Rol> findAllRoles();
}
