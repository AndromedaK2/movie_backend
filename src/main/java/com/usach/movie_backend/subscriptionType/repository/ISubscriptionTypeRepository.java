package com.usach.movie_backend.subscriptionType.repository;

import com.usach.movie_backend.subscriptionType.domain.SubscriptionType;
import com.usach.movie_backend.subscriptionType.domain.SubscriptionTypes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ISubscriptionTypeRepository extends JpaRepository<SubscriptionType,Integer> {
    List<SubscriptionType>findAll();
    Optional<SubscriptionType> findByNameSubscription(String subscriptionTypeName);
}
