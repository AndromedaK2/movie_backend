package com.usach.movie_backend.producers.service;


import com.usach.movie_backend.producers.domain.Producer;
import com.usach.movie_backend.producers.repository.IProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProducerService implements IProducerService<Producer> {

    @Autowired
    IProducerRepository iProducerRepository;

    @Override
    public List<Producer> findAll() {
        return iProducerRepository.findAll();
    }

    @Override
    public Optional<Producer> findByProducer(Integer idProducer) {
        return iProducerRepository.findById(idProducer);
    }

    @Override
    public Producer create(Producer producer) {
        return iProducerRepository.save(producer);
    }

    @Override
    public Producer update(Producer producer) {
        return iProducerRepository.save(producer);
    }

    @Override
    public void delete(Integer idProducer) {iProducerRepository.deleteById(idProducer);
    }
}
