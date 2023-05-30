package com.usach.movie_backend.suscription.service;


import com.usach.movie_backend.suscription.domain.Subscription;
import com.usach.movie_backend.suscription.repository.ISubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService implements ISubscriptionService<Subscription>{
    @Autowired
    private ISubscriptionRepository iSubscriptionRepository;

    @Override
    public List<Subscription> findAll() {
        return iSubscriptionRepository.findAll();
    }

    @Override
    public Optional<Subscription> findBySubscription(Integer idSubscription) {
        return iSubscriptionRepository.findById(idSubscription);
    }

    @Override
    public Subscription create(Subscription subscription) {
        return iSubscriptionRepository.save(subscription);
    }

    @Override
    public Subscription update(Subscription subscription) {
        return  iSubscriptionRepository.save(subscription);
    }

    @Override
    public void delete(Integer idSubscription) {
    iSubscriptionRepository.deleteById(idSubscription);
    }
}
