package com.usach.movie_backend.subscriptionType.service;

import com.usach.movie_backend.subscriptionType.domain.SubscriptionType;

import java.util.List;
import java.util.Optional;

public interface ISubscriptionTypeService{
    List<SubscriptionType> findAll();

    Optional<SubscriptionType> findByIdSubscriptionType(Integer SubscriptionType);

    SubscriptionType create(SubscriptionType subscriptionType);

    SubscriptionType update(SubscriptionType subscriptionType);

    void delete(Integer id);
}
