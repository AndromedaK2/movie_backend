package com.usach.movie_backend.producers.repository;


import com.usach.movie_backend.producers.domain.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProducerRepository extends JpaRepository<Producer,Integer> {

    List<Producer> findAll();
}
