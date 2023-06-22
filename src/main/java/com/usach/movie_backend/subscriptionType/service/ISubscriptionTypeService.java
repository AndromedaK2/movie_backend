package com.usach.movie_backend.subscriptionType.service;

import com.usach.movie_backend.subscriptionType.domain.SubscriptionType;
import com.usach.movie_backend.subscriptionType.domain.SubscriptionTypes;
import com.usach.movie_backend.subscriptionType.service.dto.SubscriptionTypeCreate;
import com.usach.movie_backend.subscriptionType.service.dto.SubscriptionTypeUpdate;

import java.util.List;
import java.util.Optional;

public interface ISubscriptionTypeService{
    List<SubscriptionType> findAll();

    SubscriptionType findByIdSubscriptionType(Integer SubscriptionType);

    SubscriptionType findBySubscriptionTypeName(SubscriptionTypes subscriptionTypeName);

    SubscriptionType create(SubscriptionTypeCreate subscriptionType);

    SubscriptionType update(SubscriptionTypeUpdate subscriptionType);

    void delete(Integer id);
}
