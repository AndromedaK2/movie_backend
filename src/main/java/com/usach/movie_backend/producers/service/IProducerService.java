package com.usach.movie_backend.producers.service;



import com.usach.movie_backend.producers.domain.Producer;

import java.util.List;
import java.util.Optional;

public interface IProducerService<T> {
    List<Producer> findAll();

    Optional<Producer> findByProducer(Integer idProducer);

    Producer create(Producer producer);

    Producer update(Producer producer);

    void delete(Integer idProducer);
}
