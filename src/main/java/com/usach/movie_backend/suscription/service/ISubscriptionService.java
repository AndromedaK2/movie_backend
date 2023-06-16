package com.usach.movie_backend.suscription.service;

import com.usach.movie_backend.subscriptionType.domain.SubscriptionTypes;
import com.usach.movie_backend.suscription.domain.Subscription;

import java.util.List;
import java.util.Optional;

public interface ISubscriptionService{

    List<Subscription> findAll();

    Optional<Subscription> findBySubscription(Integer idSubscription);

    Subscription create(String userEmail, SubscriptionTypes subscriptionTypes);

    Subscription update(Subscription subscription);

    void delete(Integer idSubscription);
}
