package com.usach.movie_backend.producers.repository;

import com.usach.movie_backend.producers.domain.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IProducerRepository extends JpaRepository<Producer,Integer> {

    List<Producer> findAll();
    Optional<Producer> findByName(String name);
}
