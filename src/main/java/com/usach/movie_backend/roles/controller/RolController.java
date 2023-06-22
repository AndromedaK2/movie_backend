package com.usach.movie_backend.roles.controller;

import com.usach.movie_backend.roles.domain.Rol;
import com.usach.movie_backend.roles.service.IRolService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@RequestMapping("/roles")
@Tag(name="roles", description = "Roles Management API")
public class RolController {

    @Autowired
    private IRolService rolService;

    @Operation(
            summary = "Retrieve a Rol by Id",
            description = "Get a Rol object by specifying its id",
            tags = { "roles", "get" })
    @GetMapping("/{idRol}")
    public ResponseEntity<Optional<Rol>> findByIdRol(@PathVariable Integer idRol ){
        Optional<Rol> rol = rolService.findByIdRol(idRol);
        return new ResponseEntity<>(rol, HttpStatus.OK);
    }
    @Operation(
            summary = "Retrieve Roles",
            description = "Get Roles",
            tags = { "users", "get" })
    @GetMapping
    public ResponseEntity<List<Rol>> findAll(){
        List<Rol> roles = rolService.findAllRoles();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }
}
