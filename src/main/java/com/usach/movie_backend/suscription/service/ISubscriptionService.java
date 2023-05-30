package com.usach.movie_backend.suscription.service;


import com.usach.movie_backend.suscription.domain.Subscription;

import java.util.List;
import java.util.Optional;

public interface ISubscriptionService <T>{

    List<Subscription> findAll();

    Optional<Subscription> findBySubscription(Integer idSubscription);

    Subscription create(Subscription subscription);

    Subscription update(Subscription subscription);

    void delete(Integer idSubscription);
}
