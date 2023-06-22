package com.usach.movie_backend.producers.service;

import com.usach.movie_backend.producers.domain.Producer;
import com.usach.movie_backend.producers.service.dto.ProducerCreate;
import com.usach.movie_backend.producers.service.dto.ProducerUpdate;

import java.util.List;

public interface IProducerService{
    List<Producer> findAll();

    Producer findByIdProducer(Integer idProducer);

    Producer create(ProducerCreate producerCreate);

    Producer update(ProducerUpdate producerUpdate);

    void delete(Integer idProducer);

    Producer findByName(String name);
}
