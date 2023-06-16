package com.usach.movie_backend.subscriptionType.service;

import com.usach.movie_backend.subscriptionType.domain.SubscriptionType;
import com.usach.movie_backend.subscriptionType.domain.SubscriptionTypes;

import java.util.List;
import java.util.Optional;

public interface ISubscriptionTypeService{
    List<SubscriptionType> findAll();

    Optional<SubscriptionType> findByIdSubscriptionType(Integer SubscriptionType);

    Optional<SubscriptionType> findBySubscriptionTypeName(SubscriptionTypes subscriptionTypeName);

    SubscriptionType create(SubscriptionType subscriptionType);

    SubscriptionType update(SubscriptionType subscriptionType);

    void delete(Integer id);
}
