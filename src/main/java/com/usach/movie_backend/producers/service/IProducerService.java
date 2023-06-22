package com.usach.movie_backend.producers.service;

import com.usach.movie_backend.producers.domain.Producer;

import java.util.List;

public interface IProducerService{
    List<Producer> findAll();

    Producer findByIdProducer(Integer idProducer);

    Producer create(Producer producer);

    Producer update(Producer producer);

    void delete(Integer idProducer);

    Producer findByName(String name);
}
