package com.usach.movie_backend.producers.service;


import com.usach.movie_backend.producers.domain.Producer;
import com.usach.movie_backend.producers.repository.IProducerRepository;
import com.usach.movie_backend.producers.service.dto.ProducerCreate;
import com.usach.movie_backend.producers.service.dto.ProducerUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProducerService implements IProducerService{

    @Autowired
    IProducerRepository producerRepository;


    @Transactional(readOnly = true)
    public List<Producer> findAll() {
        return producerRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Producer findByIdProducer(Integer idProducer) {
        Optional<Producer> producer = producerRepository.findById(idProducer);
        if(producer.isEmpty())
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND,"Producer not found");
        return producer.get();
    }

    @Transactional(readOnly = true)
    public Producer findByName(String name) {
        Optional<Producer> producer = producerRepository.findByName(name);
        if(producer.isEmpty())
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND,"Producer not found");
        return producer.get();
    }
    @Transactional(rollbackFor = {ResponseStatusException.class})
    public Producer create(ProducerCreate producerCreate) {
        if(producerRepository.findByName(producerCreate.name()).isPresent())
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Producer already exists");
        Producer producer = new Producer();
        producer.setNameProducer(producerCreate.name());
        return producerRepository.save(producer);
    }

    @Transactional(rollbackFor = {ResponseStatusException.class})
    public Producer update(ProducerUpdate producerUpdate) {
        Producer producer = findByName(producerUpdate.name());
        producer.setNameProducer(producerUpdate.name());
        return producerRepository.save(producer);
    }

    @Transactional(rollbackFor = {ResponseStatusException.class})
    public void delete(Integer idProducer) {
        producerRepository.deleteById(idProducer);
    }


}
