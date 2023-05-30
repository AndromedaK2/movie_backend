package com.usach.movie_backend.rol.controller;

import com.usach.movie_backend.rol.domain.Rol;
import com.usach.movie_backend.rol.service.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rol")
public class RolController {

    @Autowired
    private IRolService rolService;

    @GetMapping("/{idRol}")
    public ResponseEntity<Optional<Rol>> findByIdRol(@PathVariable Integer idRol ){
        Optional<Rol> rol = rolService.findByIdRol(idRol);
        return new ResponseEntity<>(rol, HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Rol>> findAll(){
        List<Rol> roles = rolService.findAllRoles();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }
}
